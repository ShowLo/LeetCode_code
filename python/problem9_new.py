class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False;
        digit = 1;
        while x//digit:
            digit *= 10;
        digit = digit // 10;
        while x:
            left = x // digit;
            right = x % 10;
            if left != right:
                return False;
            x -= left * digit;
            x = x // 10;
            digit = digit // 100;
        return True;