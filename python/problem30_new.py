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
        wordIndex = {word:[] for word in words};
        for word in words:
            matchNum[word] += 1;                                                #记录每个单词在单词组出现次数
        sLen = len(s);
        wordLen = len(words[0]);
        wordNum = len(words);
        for i in range(wordLen):
            left = i;                                                           #左窗口
            right = i + wordLen;                                                #右窗口
            while right <= sLen:
                substr = s[right - wordLen : right];                            #在字符串中切出一个跟单词一样长度的子串
                    
                if substr not in matchNum:                                      #子串不存在于单词组里
                    left = right;                                               #左窗口可以直接移到这个子串后面
                    wordDict = {word:0 for word in words};                      #单词出现次数清零
                    wordIndex = {word:[] for word in words};                    #单词索引清空
                        
                elif wordDict[substr] >= matchNum[substr]:                      #子串出现次数超过在单词组中出现次数
                    temp = left;                                                #记录旧的左窗口位置
                    left = wordIndex[substr].pop(0) + wordLen;                  #新的左窗口移动到这个子串在窗口中第一次出现的位置的右边
                    wordIndex[substr].append(right - wordLen);                  #将新的子串位置加入
                    for t in range(temp,left - wordLen,wordLen):                #将旧的左窗口到新的左窗口之间所有子串出现次数均减一
                        wordDict[s[t:t+wordLen]] -= 1;
                            
                else:                                                           #正常情况                                           
                    wordDict[substr] += 1;                                      #出现次数加一
                    wordIndex[substr].append(right - wordLen);                  #将其位置加入
                    if right - left == wordLen * wordNum:                       #匹配成功
                        result.append(left);
                        left += wordLen;                                        #左窗口右移
                        right = left;                                 
                        wordDict = {word:0 for word in words};                  #清零
                        wordIndex = {word:[] for word in words};                #清空
                            
                right += wordLen;                                               #右窗口右移
            wordDict = {word:0 for word in words};
            wordIndex = {word:[] for word in words};

        return result;