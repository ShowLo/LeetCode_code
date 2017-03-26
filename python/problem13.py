class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanInt = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000};
        num = romanInt[s[0]];
        for i in range(1,len(s)):
            if romanInt[s[i]] > romanInt[s[i - 1]]:
                num += romanInt[s[i]] - 2 * romanInt[s[i - 1]];
            else:
                num += romanInt[s[i]];
        return num;