class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        self.recursion(nums, 0, result)                         #用两两交换元素的方法递归得到所有排列
        return result
        
    def recursion(self, nums, position, result):
        numsLen = len(nums)
        if position >= numsLen:
            temp = [i for i in nums]                            #深拷贝
            result.append(temp)
        for i in range(position, numsLen):
            nums[position], nums[i] = nums[i], nums[position]   #交换两个位置上的元素
            self.recursion(nums, position + 1, result)          #对于当前位置后面的元素，继续两两交换
            nums[position], nums[i] = nums[i], nums[position]   #还原两个位置上的元素
            