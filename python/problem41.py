class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numsLen = len(nums)
        minPositiveNum = float("inf")
        for num in nums:
            if num < minPositiveNum and num > 0:
                minPositiveNum = num            #先找出最小的正数
        if numsLen < 1 or minPositiveNum != 1:  #如果这个最小正数不是1或者数组为空，说明缺1
            return 1
        sortNum = [0] * numsLen
        for num in nums:
            if num > 0 and (num - 1 < numsLen):
                sortNum[num - 1] = num          #将各个数插入到一个排序好的数组中去
        for index in range(numsLen):
            if sortNum[index] == 0:             #从这个排序好的数组中查找缺失的那个数
                return 1 + index
        return 1 + numsLen