class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        numSet = set(arr)
        maxNum = max(arr)
        minNum = min(arr)
        if minNum == maxNum:
            return True
        n = len(arr)
        if (maxNum - minNum) % (n - 1) != 0:
            return False
        num = (maxNum - minNum) // (n - 1)
        for i in range(1, n - 1):
            if not minNum + i * num in numSet:
                return False
        return True
