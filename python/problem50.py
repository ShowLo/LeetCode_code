class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        sign = n < 0
        m = abs(n) // 2
        if sign:
            m = -m
        half = self.myPow(x, m)
        if n % 2 == 0:
            return half * half
        elif n > 0:
            return half * half * x
        else:
            return half * half / x