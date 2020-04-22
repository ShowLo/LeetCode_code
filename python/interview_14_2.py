class Solution:
    def cuttingRope(self, n: int) -> int:
        if n <= 3:
            return n - 1
        result = 1
        mod = 1000000007
        while n > 4:
            result = (result * 3) % mod
            n -= 3
        result = (result * n) % mod
        return result
