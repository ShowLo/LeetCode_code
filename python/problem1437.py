class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        N = len(nums)
        prev = -1
        i = 0
        while i < N:
            if nums[i] == 1:
                prev = i
                break
            i += 1
        while i < N - 1:
            i += 1
            if nums[i] == 1:
                if i - prev <= k:
                    return False
                prev = i
        return True
