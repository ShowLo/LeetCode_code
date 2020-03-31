class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        N = 100001
        bias = 50000
        countNums = [0 for _ in range(N)]
        for num in nums:
            countNums[num + bias] += 1
        count = 0
        for i in range(N):
            for j in range(countNums[i]):
                nums[count] = i - bias
                count += 1
        return nums
