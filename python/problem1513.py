class Solution:
    def numSub(self, s: str) -> int:
        oneCount = 0
        result = 0
        for digit in s:
            if digit == '1':
                oneCount += 1
            else:
                result += (oneCount * (oneCount + 1)) // 2
                oneCount = 0
        result += (oneCount * (oneCount + 1)) // 2
        return result % 1000_000_007
