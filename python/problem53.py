class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSum = float('-inf')
        tempSum = 0
        for n in nums:
            if tempSum >= 0:
                tempSum += n
            else:
                tempSum = n
            if tempSum > maxSum:
                maxSum = tempSum
        return maxSum