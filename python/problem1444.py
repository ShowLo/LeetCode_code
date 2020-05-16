class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        row, col = len(pizza), len(pizza[0])
        cumSum = [[0 for _ in range(col)] for _ in range(row)]
        cumSum[row - 1][col - 1] = 1 if pizza[row - 1][col - 1] == 'A' else 0
        for j in range(col - 2, -1, -1):
            cumSum[row - 1][j] += cumSum[row - 1][j + 1] + (1 if pizza[row - 1][j] == 'A' else 0)
        for i in range(row - 2, -1, -1):
            cur = 0
            for j in range(col - 1, -1, -1):
                cur += 1 if pizza[i][j] == 'A' else 0
                cumSum[i][j] += cur + cumSum[i + 1][j]
        dp = [[[0 for _ in range(col)] for _ in range(row)] for _ in range(k)]
        dp[0][0][0] = 1 if cumSum[0][0] > 0 else 0
        for p in range(1, k):
            for i in range(row):
                for j in range(col):
                    for ii in range(i):
                        if cumSum[i][j] > 0 and cumSum[ii][j] > cumSum[i][j]:
                            dp[p][i][j] += dp[p - 1][ii][j]
                    for jj in range(j):
                        if cumSum[i][j] > 0 and cumSum[i][jj] > cumSum[i][j]:
                            dp[p][i][j] += dp[p - 1][i][jj]
        return sum(dp[k - 1][i][j] for i in range(row) for j in range(col)) % 1000000007
