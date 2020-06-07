class Solution:
    def getProbability(self, balls: List[int]) -> float:
        k = len(balls)
        m = sum(balls)
        n = m // 2
        cumsum = []
        factorial = [1]
        tmp = 0
        for b in balls:
            tmp += b
            cumsum.append(tmp)
        for i in range(1, m + 1):
            factorial.append(factorial[-1] * i)
        dp = [[[0 for _ in range(k * 2 + 1)] for _ in range(n + 1)] for _ in range(k)]
        for i in range(min(balls[0] + 1, n + 1)):
            t = k - 1 if i == 0 else (k + 1 if i == balls[0] else k)
            dp[0][i][t] = 1
        for h in range(1, k):
            for x in range(balls[h] + 1):
                t = -1 if x == 0 else (1 if x == balls[h] else 0)
                for i in range(n - x + 1):
                    if cumsum[h] < i + balls[h]:
                        break
                    for j in range(max(-t, 0), k * 2 + 1):
                        if dp[h - 1][i][j] == 0:
                            continue
                        pro = dp[h - 1][i][j]
                        pro *= factorial[i + x] / (factorial[i] * factorial[x])
                        pro *= factorial[cumsum[h] - i - x] / (factorial[balls[h] - x] * factorial[cumsum[h] - i - balls[h]])
                        dp[h][i + x][j + t] += pro
        total = factorial[m]
        for b in balls:
            total /= factorial[b]
        return dp[k - 1][n][k] / total
