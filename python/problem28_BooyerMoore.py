class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        #使用Boyer-Moore算法
        lenHaystack = len(haystack);
        lenNeedle = len(needle);
        if lenNeedle == 0:
            return 0;
        i = j = lenNeedle - 1;
        last = self.last_occur(needle);         #预处理获得各个字母在模式串中最后出现位置
        while i < lenHaystack:
            if needle[j] == haystack[i]:
                if j == 0:                      #匹配成功
                    return i;
                else:                           #只是部分匹配成功，比较前一个字符
                    j -= 1;
                    i -= 1;
            else:                               #暂时失配，取下一个比较位置
                i += lenNeedle - min(j,last[haystack[i]] + 1);
                j = lenNeedle - 1;
        return -1;
            
        
    def last_occur(self,needle):
        """
        :type needle: str
        :rtype: dict
        """
        last = {'a':-1,'b':-1,'c':-1,'d':-1,'e':-1,'f':-1,'g':-1,'h':-1,'i':-1,'j':-1,'k':-1,'l':-1,'m':-1,'n':-1,'o':-1,'p':-1,'q':-1,'r':-1,'s':-1,'t':-1,'u':-1,'v':-1,'w':-1,'x':-1,'y':-1,'z':-1};
        for i in range(len(needle)):
            last[needle[i]] = i;
        return last;