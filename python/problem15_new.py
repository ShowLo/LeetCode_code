class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort();                                        #先排序
        length = len(nums);
        result = [];
        i = 0;
        while i < length - 2:                               #只遍历到倒数第3个数
            left = i + 1;                   
            right = length - 1;
            now_num = nums[i];
            while left != right:                            #当左指针和右指针相遇的时候结束一轮循环
                left_num = nums[left];
                right_num = nums[right];
                sumLR = left_num + right_num;
                if sumLR == -now_num:                       #三个数的和为0
                    result.append([now_num,left_num,right_num]);
                    left += 1;                              #这个时候左指针右移直到所在位置的数不跟其左边的一样
                    while left < right and left_num == nums[left]:
                        left += 1;
                    while i < length - 1 and now_num == nums[i + 1]:
                        i += 1;                             #第一个数的位置也需右移到另一个不一样的数上去
                elif sumLR < -now_num:                      #当三个数的和小于零时，左指针右移
                    left += 1;
                else:                                       #当三个数的和大于零时，右指针左移
                    right -= 1;
            i += 1;
        return result;