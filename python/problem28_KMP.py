class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        lenHaystack = len(haystack);
        lenNeedle = len(needle);
        nxt = self.next(needle);
        if lenNeedle == 0:
            return 0;
        i,j = 0,0;
        while i < lenHaystack:
            if haystack[i] == needle[j]:        #已经匹配j+1个字符
                if j == lenNeedle - 1:          #匹配成功
                    return i - j;
                else:                           #匹配下一个位置
                    i += 1;
                    j += 1;
            else:
                if j > 0:
                    j = nxt[j - 1];             #移动到部分匹配串
                else:
                    i += 1;
        return -1;
        
    def next(self,needle):
        """
        :type needle: str
        :rtype: list
        """
        length = len(needle);
        i,j = 1,0;
        n = [0] * length;
        while i < length:
            if needle[i] == needle[j]:          #已经匹配了j+1个字符
                n[i] = j + 1;                   #部分匹配串长度加1
                i += 1;                         #比较位置均后移
                j += 1;
            elif j > 0:                         #如果j不在字符串头，用部分匹配串对齐
                j = n[j - 1];
            else:                               #j在字符串头，部分匹配串长度为0
                n[i] = 0;
                i += 1;
        return n;