class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        mostOffen = 0
        count = 0
        for n in nums:
            if count == 0:
                mostOffen = n
                count = 1
            else:
                if mostOffen == n:
                    count += 1
                else:
                    count -= 1
        return mostOffen
