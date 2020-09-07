class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        num2count = collections.defaultdict(int)
        for num in nums:
            num2count[num] += 1
        result = 0
        for num in num2count:
            result += (num2count[num] * (num2count[num] - 1)) // 2
        return result
