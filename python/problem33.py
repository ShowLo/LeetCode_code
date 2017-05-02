class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums);
        if length == 0:
            return -1;
        if target == nums[0]:
            return 0;                       #目标值比列表中第一个值大，往后找目标值
        if target > nums[0]:
            for i in range(1,length):
                if target == nums[i]:
                    return i;
                elif nums[i] < nums[i - 1]: #如果列表中当前值比前面值大，说明到了反转点，此时后面的值都比目标值小
                    return -1;
        if target < nums[0]:
            for i in range(length - 1,0,-1):#目标值比列表中第一值小，只能从最后面往前找
                if target == nums[i]:
                    return i;
                elif nums[i - 1] > nums[i]: #如果列表中当前值比后面值大说明到了反转点，此时前面的值都比目标值大
                    return -1;
        return -1;