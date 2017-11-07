class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        x = 1
        y = 1
        t = 1
        #其实就是斐波那契数列的计算
        while t < n:
            x, y = y, x + y
            t += 1
        return y