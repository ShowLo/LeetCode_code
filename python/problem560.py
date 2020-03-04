class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        numsLen = len(nums)
        count = 0
        cumulativeSum = [nums[0]]
        for i in range(1, numsLen):     #计算累加和
            cumulativeSum.append(cumulativeSum[-1] + nums[i])
        cumuSumDict = {k : 1}           #以需要的下一个累加和为key，需要这样的下一个累加和的次数为value
        for cumuSum in cumulativeSum:
            if cumuSum in cumuSumDict:  #当前累加和已在字典中出现，说明当前索引和之前若干个索引之间的区间和为k
                count += cumuSumDict[cumuSum]
            nextCumuSum = cumuSum + k   #想要当前索引和可能的接下来某个索引之间区间和为k，那么其累加和应该在当前基础上+k
            if nextCumuSum in cumuSumDict:
                cumuSumDict[nextCumuSum] += 1
            else:
                cumuSumDict[nextCumuSum] = 1
        return count
