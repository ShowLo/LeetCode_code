class Solution:
    def printNumbers(self, n: int) -> List[int]:
        maxNum = 0
        for i in range(n):
            maxNum = maxNum * 10 + 9
        return [i for i in range(1, maxNum + 1)]
