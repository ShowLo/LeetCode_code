class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanInt = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000};#各罗马数字所对应阿拉伯数字
        num = romanInt[s[0]];
        for i in range(1,len(s)):										#根据罗马数字和阿拉伯数字对应关系进行转换
            if romanInt[s[i]] > romanInt[s[i - 1]]:
                num += romanInt[s[i]] - 2 * romanInt[s[i - 1]];
            else:
                num += romanInt[s[i]];
        return num;