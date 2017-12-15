class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mark = set()
        count = 0
        index = 0
        numsLen = len(nums)
        while index < numsLen:
            if nums[index] in mark:
                count += 1
                if count <= 2:
                    index += 1
                else:
                    nums.pop(index)
                    numsLen -= 1
            else:
                mark.add(nums[index])
                count = 1
                index += 1
        return index