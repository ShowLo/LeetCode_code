class Solution:
    def massage(self, nums: List[int]) -> int:
        dp_i_0, dp_i_1 = 0, 0
        for n in nums:
            dp_i_1, dp_i_0 = n + dp_i_0, max(dp_i_0, dp_i_1)
        return max(dp_i_0, dp_i_1)
