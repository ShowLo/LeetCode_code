class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        self.recursion(nums, 0, result)
        return result
    
    def recursion(self, nums, position, result):
        numsLen = len(nums)
        if position >= numsLen:
            temp = [i for i in nums]                                #深拷贝
            result.append(temp)
        s = set()
        for i in range(position, numsLen):
            if nums[i] not in s:                                    #确保当前要交换的元素未被交换过
                s.add(nums[i])
                nums[position], nums[i] = nums[i], nums[position]   #交换两个位置上的元素
                self.recursion(nums, position + 1, result)          #对于当前位置后面的元素，继续两两交换
                nums[position], nums[i] = nums[i], nums[position]   #还原两个位置上的元素