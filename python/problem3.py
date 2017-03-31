class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max = 0;
        substr = '';						#记录最长子串
        for ss in s:
            pos = substr.find(ss);			#记录当前字符是否在当前子串中出现过
            if pos == -1:					#没有出现
                substr = substr + ss;		#那就加入到当前子串中去
                length = len(substr);
                if length > max:			#如果当前子串比之前的更长
                    max = length;			#更新最长子串长度
            else:							#如果当前字符在当前子串中出现过
                if pos == len(substr) - 1:	#且在最后一位
                    substr = ss;			#那更新当前子串为当前字符
                else:						#不在最后一位的话就从之前出现的那位之后一位开始到当前位置作为新子串
                    substr = substr[pos + 1:] + ss;
        return max;