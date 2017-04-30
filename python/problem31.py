class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length = len(nums);
        for i in range(length - 1,0,-1):
            if nums[i] > nums[i - 1]:                       #找到第一个后面数字大于前面数字的位置
                largerIndex = i;                            #记录比前面数字大的最小的数的位置
                value = nums[i - 1];
                for j in range(largerIndex + 1,length):
                    if nums[j] > value and nums[j] < nums[largerIndex]:
                        largerIndex = j;
                nums.insert(i - 1,nums.pop(largerIndex));   #在前面数字的前面插入比其大的最小的数并将这个最小的数弹出
                nums[i::] = sorted(nums[i::]);              #将其后面的数进行排序
                return;
        nums.sort();