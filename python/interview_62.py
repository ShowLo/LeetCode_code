class Solution:
    def lastRemaining(self, n: int, m: int) -> int:
        result = 0
        for i in range(2, n + 1):
            result = (result + m) % i
        return result
