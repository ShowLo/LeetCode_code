class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        lenHaystack = len(haystack);
        lenNeedle = len(needle);
        if lenHaystack < lenNeedle:
            return -1;
        if lenHaystack == lenNeedle:
            if haystack == needle:
                return 0;
            else:
                return -1;
        if lenNeedle == 0:
            return 0;
        for i in range(lenHaystack - lenNeedle + 1):
            for j in range(lenNeedle):
                if haystack[i] != needle[j]:    #只要有一个字符不匹配就进行下一个匹配
                    break;
                else:
                    if j == lenNeedle - 1:      #匹配到最后一个字符说明匹配成功
                        return i - j;
                    i += 1;
        return -1;