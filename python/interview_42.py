class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = nums[0]
        result = dp
        for i in range(1, len(nums)):
            dp = max(dp + nums[i], nums[i])
            result = max(dp, result)
        return result
