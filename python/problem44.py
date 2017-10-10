class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        sIndex, pIndex = 0, 0
        sLen = len(s)
        pLen = len(p)
        sPrevIndex, pPrevIndex = 1, pLen
        while sIndex < sLen:
            #当两个串对应位置字母可以等价时，各自索引均向后
            if pIndex < pLen and (s[sIndex] == p[pIndex] or p[pIndex] == '?'):
                sIndex += 1
                pIndex += 1
            #当模式串为*时，先以匹配0个的方式暂时匹配
            elif pIndex < pLen and p[pIndex] == '*':
                sPrevIndex = sIndex + 1
                pPrevIndex = pIndex
                pIndex += 1
            #当暂时匹配失败时，以匹配多1个的方式继续匹配
            elif pPrevIndex < pLen:
                sIndex, pIndex = sPrevIndex, pPrevIndex
            #匹配失败
            else:
                return False
        #看模式串剩下的字母是否均为*
        for i in range(pIndex, pLen):
            if p[i] != '*':
                return False
        return True