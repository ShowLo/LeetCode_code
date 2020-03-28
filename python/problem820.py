class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        wordSet = set(words)
        for word in words:
            for i in range(1, len(word)):
                wordSet.discard(word[i:])
        return sum(len(word) + 1 for word in wordSet)
