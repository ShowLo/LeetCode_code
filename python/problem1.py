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
            num = nums[i];
            item = differDict.get(num);
            if item == None:
                differDict[target - num] = i;
            else:
                return [item,i];