class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numsLen = len(nums)
        maxReach = nums[0]
        prevReach = 0
        stepNum = 0
        for i in range(numsLen):
            if i > prevReach:           #超过了上一个最大可达范围，说明走了一步才能超过
                prevReach = maxReach    #更新上一最大可达范围为当前最大可达范围
                stepNum += 1
            if i + nums[i] > maxReach:  #更新当前可达最大范围
                maxReach = i + nums[i]
        return stepNum