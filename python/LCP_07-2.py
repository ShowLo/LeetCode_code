class Solution:
    def numWays(self, n: int, relation: List[List[int]], k: int) -> int:
        dp = [[0] * (k + 1) for _ in range(n)]
        dp[0][0] = 1
        for j in range(1, k + 1):
            for i in range(n):
                for r1, r2 in relation:
                    if r2 == i:
                        dp[r2][j] += dp[r1][j - 1]
        return dp[n - 1][k]
