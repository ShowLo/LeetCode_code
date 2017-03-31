class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums);
        differDict = {};				#用字典存放差值--索引对
        for i in range(length):
            num = nums[i];
            item = differDict.get(num);	#看当前值是否已在差值--索引字典当中
            if item == None:			#如果不在的话，将目标值与当前值作为key，索引作为value
                differDict[target - num] = i;
            else:						#存在的话，直接返回
                return [item,i];