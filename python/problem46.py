class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        import itertools
        permutation = itertools.permutations(range(len(nums)), len(nums))
        result = []
        for index in permutation:
            temp = []
            for i in index:
                temp.append(nums[i])
            result.append(temp)
        return result