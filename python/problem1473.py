class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, target: int) -> int:
        MAX_VALUE = 10_000_000
        dp = [[[MAX_VALUE for _ in range(n)] for _ in range(target)] for _ in range(m)]
        if houses[0] == 0:
            for k in range(n):
                dp[0][0][k] = cost[0][k]
        else:
            dp[0][0][houses[0] - 1] = 0
        for i in range(1, m):
            for j in range(target):
                for k in range(n):
                    if houses[i] != 0 and k != houses[i] - 1:
                        continue
                    c = cost[i][k] if houses[i] == 0 else 0
                    color = k if houses[i] == 0 else houses[i] - 1
                    minc = dp[i - 1][j][color]
                    if j > 0:
                        for p in range(n):
                            if p == k:
                                continue
                            minc = min(minc, dp[i - 1][j - 1][p])
                    dp[i][j][k] = min(dp[i][j][k], minc + c)
        result = min(dp[m - 1][target - 1][:])
        return -1 if result == MAX_VALUE else result
