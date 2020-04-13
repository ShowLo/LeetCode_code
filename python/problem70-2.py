class Solution:
    def climbStairs(self, n: int) -> int:
        dp0 = 1
        dp1 = 1
        for i in range(2, n + 1):
            temp = dp1
            dp1 = dp0 + dp1
            dp0 = temp
        return dp1
