class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        onePosition = self.binarySearch(nums, target);  #先找到一个目标值的位置
        if onePosition == -1:
            return [-1,-1];
        left,right = onePosition - 1,onePosition + 1;
        while right < len(nums):                        #然后向右拓展
            if nums[right] == target:
                right += 1;
            else:
                break;
        while left >= 0:                                #向左拓展
            if nums[left] == target:
                left -= 1;
            else:
                break;
        return [left + 1,right - 1];
        
    def binarySearch(self, nums, target):               #二分查找函数
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left,right = 0,len(nums) - 1;
        while left <= right:
            middle = (left + right) // 2;               #中点位置
            middleNum = nums[middle];
            if middleNum == target:
                return middle;
            elif middleNum > target:                    #比目标值大，找左边的
                right = middle - 1;
            else:                                       #比目标值小，找右边的
                left = middle + 1;
        return -1;