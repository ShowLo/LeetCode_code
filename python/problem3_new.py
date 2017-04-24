class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        lenS = len(s);
        maxLen = 0;
        left = right = 0;
        charDict = {};
        while right < lenS:
            if s[right] in charDict and left <= charDict[s[right]]: #出现重复的字符且这个字符在窗口中
                left = charDict[s[right]] + 1;                      #左窗口位置调整到这个重复字符的右端
            else:                                                   #没有重复字符出现
                charDict[s[right]] = right;                         #更新字符位置
                maxLen = max(maxLen,right - left + 1);              #更新最长长度
                right += 1;                                         #右窗口后移
        return maxLen;