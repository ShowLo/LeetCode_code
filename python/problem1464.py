class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        first, second = 0, 0
        for n in nums:
            if n >= first:
                first, second = n, first
            elif n > second:
                second = n
        return (first - 1) * (second - 1)
