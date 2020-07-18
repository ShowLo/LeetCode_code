class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        leftLen, rightLen = len(left), len(right)
        if leftLen == 0 and rightLen == 0:
            return 0
        if leftLen == 0:
            return n - min(right)
        if rightLen == 0:
            return max(left)
        return max(n - min(right), max(left))
