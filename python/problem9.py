class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False;
        reverse = 0;
        temp = x;
        while  temp:
            reverse = reverse * 10 + temp % 10;
            temp = temp // 10;
        return x == reverse;