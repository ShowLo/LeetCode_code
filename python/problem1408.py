class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        words.sort(key=len, reverse=True)
        L = len(words)
        result = []
        for i in range(L):
            for j in range(i):
                if words[i] in words[j]:
                    result.append(words[i])
                    break
        return result
