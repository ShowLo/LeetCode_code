class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums);
        r = [];
        for m in range(0,length):
            for n in range(m + 1,length):
                if nums[m] + nums[n] == target:
                    r.append(m);
                    r.append(n);
        return r;