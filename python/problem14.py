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
        while flag:
            for i in range(length - 1):
                if len(strs[i]) == 0 or len(strs[i + 1]) == 0:
                    return '';
                elif strs[i][maxLen] != strs[i + 1][maxLen]:
                    flag = False;
                    break;
                else:
                    if len(strs[i]) == maxLen + 1 or len(strs[i + 1]) == maxLen + 1:
                        flag = False;
                    if i == length - 2:
                            maxLen += 1;
        return strs[0][0:maxLen];