class Solution:
    def minArray(self, numbers: List[int]) -> int:
        left, right = 0, len(numbers) - 1
        while left < right:
            if left == right - 1:
                return min(numbers[left], numbers[right])
            middle = left + (right - left) // 2
            if numbers[middle] > numbers[right]:
                left = middle
            elif numbers[middle] < numbers[right]:
                right = middle
            else:
                right -= 1
        return numbers[0]
