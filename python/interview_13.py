class Solution:
    def digitSum(self, n):
        return n // 10 + n % 10

    def movingCount(self, m: int, n: int, k: int) -> int:
        visited = [[False for _ in range(n)] for _ in range(m)]

        def dfs(i, j):
            if i < 0 or j < 0 or i >= m or j >= n or visited[i][j]:
                return 0
            visited[i][j] = True
            if self.digitSum(i) + self.digitSum(j) <= k:
                return 1 + dfs(i + 1, j) + dfs(i, j + 1)
            return 0

        return dfs(0, 0)
