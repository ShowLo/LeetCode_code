class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s)
        n = len(p)
        dp = [[False for _ in range(n + 1)] for _ in range(m + 1)]
        dp[0][0] = True
        j = 2
        while j <= n:
            if p[j - 1] == '*':
                dp[0][j] = True
                j += 2
            else:
                break
        
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] != '*':
                    dp[i][j] = (s[i - 1] == p[j - 1] or p[j - 1] == '.') and dp[i - 1][j - 1]
                else:
                    if j >= 2:
                        dp[i][j] = dp[i][j - 2] or ((s[i - 1] == p[j - 2] or p[j - 2] == '.') and dp[i - 1][j])
        return dp[m][n]
