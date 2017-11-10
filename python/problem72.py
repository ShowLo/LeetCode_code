class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        if maxWidth == 0:
            return  ['']
        wordsNum = len(words)
        currentLen = 0
        groupNum = 0
        group = [[]]
        groupWidth = []
        for i in range(wordsNum):
            wordLen = len(words[i])
            if currentLen + wordLen <= maxWidth:    #如果加上当前字符串不会超过最大长度
                if i == wordsNum - 1:
                    groupWidth.append(currentLen + wordLen)
                    group[groupNum].append(i)
                    groupNum += 1
                else:
                    currentLen += wordLen + 1       #更新当前行的长度，每个字符串都加上一个空格
                    group[groupNum].append(i)       #记录当前行包含的字符串索引
            else:                                   #如果加上当前字符串就超过了最大长度
                groupWidth.append(currentLen - 1)   #一行完成，记录此行的字符串的总长，最后一个字符串后面跟着的空格应去掉
                currentLen = wordLen + 1
                group.append([i])
                groupNum += 1
                if i == wordsNum - 1:
                    groupWidth.append(wordLen)
                    groupNum += 1
        result = []
        for i in range(groupNum - 1):
            spaceWidth = maxWidth - groupWidth[i]   #应该再多加入的空格
            num = len(group[i])
            s = ''
            if num == 1:
                s = words[group[i][0]] + ' ' * spaceWidth
            else:
                baseWidth = spaceWidth // (num - 1) #每个单词后面都要加入的空格基本量
                appendIndex = spaceWidth % (num - 1)#前几个单词后面还要多加入一个空格
                for index in range(appendIndex):
                    s += words[group[i][index]] + ' ' * (baseWidth + 2)
                for index in range(appendIndex, num - 1):
                    s += words[group[i][index]] + ' ' * (baseWidth + 1)
                s += words[group[i][num - 1]]       #最后一个单词后面就不加空格了
            result.append(s)
        #但是对于最后一行必须特殊处理，单词之间只加一个空格，其他的全部加到最后边去
        spaceWidth = maxWidth - groupWidth[groupNum - 1]
        num = len(group[groupNum - 1])
        s = ''
        if num == 1:
            s = words[group[groupNum - 1][0]] + ' ' * spaceWidth
        else:
            for index in range(num - 1):
                s += words[group[groupNum - 1][index]] + ' '
            s += words[group[groupNum - 1][num - 1]] + ' ' * spaceWidth
        result.append(s)
        return result