class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        if m * k > len(bloomDay):
            return -1
        def isValid(day):
            count = 0
            cursum = 0
            for bd in bloomDay:
                if bd <= day:
                    cursum += 1
                else:
                    cursum = 0
                if cursum == k:
                    count += 1
                    cursum = 0
                if count >= m:
                    break
            return count >= m

        left, right = 0, max(bloomDay)
        while left < right:
            middle = (left + right) // 2
            if isValid(middle):
                right = middle
            else:
                left = middle + 1
        return right
