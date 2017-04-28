class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        result = [];
        wordDict = {word:0 for word in words};
        matchNum = {word:0 for word in words};
        for word in words:
            matchNum[word] += 1;                                                #记录每个单词出现次数
        wordLen = len(words[0]);
        wordNum = len(words);
        for  i in range(len(s) - wordLen * wordNum + 1):
            for j in range(1,wordNum + 1):
                substr = s[i + (j - 1) * wordLen : i + j * wordLen];            #在字符串中切出一个跟单词一样长度的子串 
                if substr in wordDict and wordDict[substr] < matchNum[substr]:  #如果单词存在于字典中且出现次数为零
                    wordDict[substr] += 1;                                      #出现次数加一
                    if j == wordNum:                                            #匹配成功
                        result.append(i);
                else:
                    break;
            wordDict = {word:0 for word in words};                              #出现次数清零
        return result;