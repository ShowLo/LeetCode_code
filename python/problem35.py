class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums);
        if target <= nums[0]:
            return 0;
        if target > nums[-1]:
            return length;
        for i in range(length):
            if nums[i] >= target:
                return i;