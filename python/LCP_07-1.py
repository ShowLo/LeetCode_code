class Solution:
    def numWays(self, n: int, relation: List[List[int]], k: int) -> int:
        id2list = {}
        for r in relation:
            if r[0] in id2list:
                id2list[r[0]].append(r[1])
            else:
                id2list[r[0]] = [r[1]]
        
        self.count = 0
        def dfs(n, k, idx):
            if k == 0:
                if idx == n - 1:
                    self.count += 1
                return
            if idx in id2list:
                for i in id2list[idx]:
                    dfs(n, k - 1, i)
        
        dfs(n, k, 0)
        return self.count
