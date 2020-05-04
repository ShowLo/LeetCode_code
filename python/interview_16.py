class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0 or x == 1.0:
            return 1.0
        if n < 0:
            return self.myPow(1 / x, -n)
        result = 1.0
        while n > 0:
            if (n & 1) == 1:
                result *= x
            x *= x
            n >>= 1
        return result
