class Solution:
    def trap(self, height: List[int]) -> int:
        N = len(height)
        if N <= 2:
            return 0
        left, right = 0, N - 1
        left_max, right_max = height[0], height[N - 1]
        result = 0
        while left < right:
            if left_max < right_max:
                result += left_max - height[left]
                left += 1
                left_max = max(left_max, height[left])
            else:
                result+= right_max - height[right]
                right -= 1
                right_max = max(right_max, height[right])
        return result
