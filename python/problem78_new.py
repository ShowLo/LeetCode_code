class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        #把从0到numsLen的数转为二进制，例如000代表[]，011代表取后两个数，111代表取全部三个数
        numsLen = len(nums)
        result = [[]]
        for i in range(1, 1 << numsLen):
            temp = []
            for j in range(numsLen):
                if i & (1 << j) != 0:   #第j位上是否为1
                    temp.append(nums[j])
            result.append(temp)
        return result