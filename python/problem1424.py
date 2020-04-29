class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        N = len(nums)
        idx2list = {}
        count = 0
        for i in range(N - 1, -1, -1):
            L = len(nums[i])
            for j in range(L):
                if i + j in idx2list:
                    idx2list[i + j].append(nums[i][j])
                else:
                    idx2list[i + j] = [nums[i][j]]
            count += L
        result = []
        keys = sorted(list(idx2list.keys()))
        for k in keys:
            result.extend(idx2list[k])
        return result
