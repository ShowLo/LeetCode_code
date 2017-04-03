class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        length = len(strs);
        if length == 0:
            return '';
        if length == 1:
            return strs[0];
        flag = True;
        maxLen = 0;
        for i in range(length):				#如果有任何一个字符串为空，直接返回空字符串
            if len(strs[i]) == 0:
                return '';
        while flag:
            for i in range(length): 		#遍历list
				str = strs[0][maxLen];
				if strs[i][maxLen] != str:	#如果有对应位置的字符不一样了，退出循环
				    flag = False;
				    break;
				else:						#对应位置的字符目前是一样的
											#如果目前的maxLen已经是某个字符串的长度了,进行内层循环之后就退出
					if len(strs[i]) == maxLen + 1:
					    flag = False;
					if i == length - 1:		#如果这已经是list的最后一个字符串
					    maxLen += 1;
        return strs[0][0:maxLen];