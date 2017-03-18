class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s = str(abs(x));
        if x >= 0:
            r = int(s[::-1]);
        else:
            r = -int(s[::-1]);
        if r > 2**31 - 1 or r < -2**31:
            return 0;
        else:
            return r;