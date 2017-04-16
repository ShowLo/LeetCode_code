class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        length = len(nums);
        result = 0;
        for i in range(length):
            if nums[i] == val:
                continue;
            else:
                nums[result] = nums[i];
                result += 1;
        return result;