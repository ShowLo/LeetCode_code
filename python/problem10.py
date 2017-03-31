class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        sLen = len(s);
        pLen = len(p);
        if pLen == 0:				#当p为空时，只有s也为空才能匹配
            return sLen == 0;
        if sLen == 0:				#当s为空时,p的形式需为"a*b*c*"
            return pLen % 2 == 0 and p[1::2] == '*' * (pLen // 2);
        if sLen == 1 and pLen == 1:		#s和p均为单字符时或者相同、或者p为'.'时才能匹配成功
            return s == p or p == '.';
        if sLen != 1 and pLen == 1:		#p为单字符而s不是时，一定匹配失败
            return False;
        if p[1] != '*':				#第一种情况，不带*
            if p[0] == s[0] or p[0] == '.': 	#头个字符匹配成功的话，匹配是否成功取决于去掉头字符之后的字符串
                return self.isMatch(s[1:],p[1:]);
            else:
                return False;
        else:					#另一种情况，带*
						#匹配0/1/2……个字符的情况
            while len(s) > 0 and (p[0] == s[0] or p[0] == '.'):
                if self.isMatch(s,p[2:]):	#看字符串与去掉头两个字符的模式串是否匹配，匹配的话整个就匹配了
                    return True;
                s = s[1:];			#匹配还没最终成功的情况下每次字符串都要先减掉一个匹配字符
            return self.isMatch(s,p[2:]);	#还是没有匹配成功，那最终是否匹配就取决于去掉已匹配字符之后的字符串与模式串
