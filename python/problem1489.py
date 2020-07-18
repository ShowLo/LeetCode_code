class Solution:
    def __init__(self):
        self.MAX_VALUE = 1e6

    def find(self, prev, node):
        # 并查集的查找操作
        if prev[node] != node:
            # 路径压缩
            prev[node] = self.find(prev, prev[node])
        return prev[node]
    
    def kruskal(self, edges, n, k, remove=True):
        # 找最小生成树
        prev = [i for i in range(n)]
        count, cost = 0, 0
        if not remove:
            # 必包含第k条边
            prev[self.backup[k][1]] = self.backup[k][0]
            cost = self.backup[k][2]
            count = 1
        
        for i, edge in enumerate(edges):
            if remove and k >= 0 and edge == self.backup[k]:
                # 不包括第k条边
                continue
            
            p1, p2 = self.find(prev, edge[0]), self.find(prev, edge[1])
            if p1 == p2:
                # 如果位于同一棵树，避免成环直接跳过
                continue
            # 两棵树的合并
            prev[p2] = p1
            cost += edge[2]
            count += 1
            if count == n - 1:
                return cost
        return self.MAX_VALUE

    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        # 只是保持顺序，不用深拷贝
        self.backup = [edge for edge in edges]
        # 按权值升序排序
        edges.sort(key=lambda x : x[2])
        minCost = self.kruskal(edges, n, -1)

        result = [[], []]
        for i in range(len(edges)):
            if self.kruskal(edges, n, i) > minCost:
                # 关键边
                result[0].append(i)
            elif self.kruskal(edges, n, i, False) == minCost:
                # 伪关键边
                result[1].append(i)
        return result
