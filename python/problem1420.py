class Solution:
    def numOfArrays(self, n: int, m: int, k: int) -> int:
        if k == 0 or k > m:
            return 0
        mod = 1000000007
        dp = [[[0 for _ in range(k + 1)] for _ in range(m + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            dp[i][1][1] = 1
        for j in range(1, m + 1):
            dp[1][j][1] = 1
        for i in range(2, n + 1):
            for p in range(1, k + 1):
                s = 0
                for j in range(2, m + 1):
                    s = (s + dp[i - 1][j - 1][p - 1]) % mod
                    dp[i][j][p] = (s + j * dp[i - 1][j][p]) % mod
        result = 0
        for j in range(1, m + 1):
            result += dp[n][j][k]
        return result % mod
