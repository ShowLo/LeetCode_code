class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        N = len(nums)
        leftMax = [0] * N
        rightMax = [0] * N
        MIN_VALUE = -10001
        curMax = 0
        for i in range(N):
            if i % k == 0:
                curMax = MIN_VALUE
            curMax = max(curMax, nums[i])
            leftMax[i] = curMax
        for i in range(N - 1, -1, -1):
            if (i + 1) % k == 0:
                curMax = MIN_VALUE
            curMax = max(curMax, nums[i])
            rightMax[i] = curMax
        result = []
        for i in range(N - k + 1):
            if i % k == 0:
                result.append(rightMax[i])
            else:
                result.append(max(rightMax[i], leftMax[i + k - 1]))
        return result
