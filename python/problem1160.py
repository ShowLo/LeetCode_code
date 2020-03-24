class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        charNum = [0 for _ in range(26)]
        for i in range(len(chars)):             #记录字母表中各个字母出现次数
            charNum[ord(chars[i]) - 97] += 1
        
        def fromWords(word):                    #判断某个单词能否由字母表中的字母拼成
            tmp = [0 for _ in range(26)]
            for i in range(len(word)):
                idx = ord(word[i]) - 97
                if tmp[idx] >= charNum[idx]:    #超过次数的就失败了
                    return False
                tmp[idx] += 1
            return True
        
        sumLen = 0
        for i in range(len(words)):
            if (fromWords(words[i])):
                sumLen += len(words[i])
        return sumLen
