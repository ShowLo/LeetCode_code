class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
		#couldn't pass the test because of Time Limit Exceeded
        length = len(s);
        if length == 1:
            return s;
        maxLen = 0;
        str = "";
        for i in range(length):
            for j in range(length - 1,min(i + maxLen - 1,length - 1) - 1,-1):
                substr = s[i:j + 1];
                if substr == substr[::-1]:
				    if j + 1 - i > maxLen:
				        maxLen = j + 1 - i;
				        str = substr;
				    continue;
        return str;