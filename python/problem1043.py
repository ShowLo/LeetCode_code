class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        count = [0 for _ in range(100)]
        totalSum = 0
        for n in nums:
            totalSum += n
            count[n - 1] += 1
        result = []
        cumSum = 0
        for i in range(99, -1, -1):
            for j in range(count[i]):
                result.append(i + 1)
                cumSum += i + 1
                if cumSum > totalSum - cumSum:
                    return result
        return result
