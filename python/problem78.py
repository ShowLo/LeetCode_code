class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        import itertools
        numsLen = len(nums)
        result = [[]]
        for i in range(1, numsLen + 1):
            combination = list(itertools.combinations(nums, i))
            for c in combination:
                result.append(list(c))
        return result