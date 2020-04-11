class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        N = len(stoneValue)
        dp0, dp1, dp2 = 0, stoneValue[N - 1], 0
        totalSum = stoneValue[N - 1]
        if N - 2 >= 0:
            totalSum += stoneValue[N - 2]
            dp0 = totalSum - min(dp1, dp2)
        else:
            dp0 = dp1
        for i in range(N - 3, -1, -1):
            totalSum += stoneValue[i]
            temp = dp0
            dp0 = totalSum - min(dp0, dp1, dp2)
            dp2 = dp1
            dp1 = temp
        if dp0 * 2 > totalSum:
            return 'Alice'
        elif dp0 * 2 < totalSum:
            return 'Bob'
        else:
            return 'Tie'
