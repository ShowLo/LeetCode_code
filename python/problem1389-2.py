class Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        L = len(nums)
        result = [-1 for _ in range(L)]
        for i in range(L - 1, -1, -1):
            count = -1
            for j in range(L):
                if result[j] == -1:
                    count += 1
                    if count == index[i]:
                        result[j] = nums[i]
                        break
        return result
