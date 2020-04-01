class Solution:
    def findLucky(self, arr: List[int]) -> int:
        num2count = {}
        for a in arr:
            if a in num2count:
                num2count[a] += 1
            else:
                num2count[a] = 1
        result = -1
        for num, count in num2count.items():
            if num == count:
                result = max(result, num)
        return result
