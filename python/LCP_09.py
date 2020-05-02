class Solution:
    def minJump(self, jump: List[int]) -> int:
        N = len(jump)
        dp = [0] * N
        for i in range(N - 1, -1, -1):
            if i + jump[i] >= N:
                dp[i] = 1
            else:
                dp[i] = dp[i + jump[i]] + 1
            j = i + 1
            while j < N and dp[j] >= dp[i] + 1:
                dp[j] = dp[i] + 1
                j += 1
        return dp[0]
