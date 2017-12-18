class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        length = len(nums);
        if length == 0:
            return False;
        if target == nums[0]:
            return True;
        if target > nums[0]:                    #目标值比列表中第一个值大，往后找目标值
            for i in range(1,length):
                if target == nums[i]:
                    return True;
                elif nums[i] < nums[i - 1]:     #如果列表中当前值比前面值大，说明到了反转点，此时后面的值都比目标值小
                    return False;
        else:
            for i in range(length - 1, 0, -1):  #目标值比列表中第一值小，只能从最后面往前找
                if target == nums[i]:
                    return True;
                elif nums[i - 1] > nums[i]:     #如果列表中当前值比后面值大说明到了反转点，此时前面的值都比目标值大
                    return False;
        return False;