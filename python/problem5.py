class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        length = len(s);
        maxLen = 0;
        str = "";
        for i in range(length):
            for j in range(min(i + maxLen + 1,length),length + 1):
                substr = s[i:j];
                if substr == substr[::-1]:
				    if j - i > maxLen:
				        maxLen = j - i;
				        str = substr;
        return str;