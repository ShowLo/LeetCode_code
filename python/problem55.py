class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        numsLen = len(nums)
        start = 0
        end = 0
        while start <= end:
            temp = start + nums[start]
            if temp > end:
                end = temp
            if end >= numsLen - 1:
                return True
            start += 1
        return False