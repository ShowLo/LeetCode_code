class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums);
        differDict = {};
        for i in range(length):
            if differDict.get(nums[i]) == None:
                differDict[target - nums[i]] = i;
            else:
                return [differDict[nums[i]],i];