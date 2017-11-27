class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        num0 = 0
        num1 = 0
        num2 = 0
        for num in nums:
            if num == 0:
                num0 += 1
            elif num == 1:
                num1 += 1
            else:
                num2 += 1
        for i in range(num0 + num1 + num2):
            if i < num0:
                nums[i] = 0
            elif i < num0 + num1:
                nums[i] = 1
            else:
                nums[i] = 2