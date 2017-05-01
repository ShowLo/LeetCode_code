class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        sLen = len(s);
        validLen = [0] * sLen;
        
        if sLen == 0:
            return 0;
        
        for i in range(sLen - 2,-1,-1):
            if s[i] == '(':
                nextMacthPosition = i + validLen[i + 1] + 1;                #与当前符号可能匹配的符号位置
                if nextMacthPosition < sLen and s[nextMacthPosition] == ')':#这个位置没越界且匹配
                    validLen[i] = validLen[i + 1] + 2;                      #更新匹配长度
                    if nextMacthPosition + 1 < sLen:
                        validLen[i] += validLen[nextMacthPosition + 1];
                
        return max(validLen);