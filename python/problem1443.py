class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        figure = collections.defaultdict(list)
        visited = [False] * n
        for edge in edges:
            figure[edge[0]].append(edge[1])
            figure[edge[1]].append(edge[0])
        
        def dfs(node):
            visited[node] = True
            res = 0
            for nextNode in figure[node]:
                if not visited[nextNode]:
                    res += dfs(nextNode)
            if res == 0:
                return 2 if hasApple[node] else 0
            else:
                return res + 2
        
        result = dfs(0)
        return 0 if result == 0 else result - 2
