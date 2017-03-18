class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        temp = abs(x);
        result = 0;
        while  temp:
            r = temp % 10;
            temp = temp // 10;
            result = result * 10 + r;
        if x < 0:
            result = - result;
        if result > 2**31 - 1 or result < -2**31:
            return 0;
        return result;