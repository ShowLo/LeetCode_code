class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        N = len(nums)
        deque = collections.deque()
        dp = [0] * N
        dp[0] = nums[0]
        result = dp[0]
        deque.append(0)
        for i in range(1, N):
            dp[i] = nums[i] + max(0, dp[deque[0]])
            while len(deque) > 0 and dp[deque[-1]] < dp[i]:
                deque.pop()
            deque.append(i)
            if i - deque[0] >= k:
                deque.popleft()
            result = max(result, dp[i])
        return result
