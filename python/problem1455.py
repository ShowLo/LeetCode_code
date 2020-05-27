class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        strs = sentence.split()
        i, n = 0, len(strs)
        while i < n:
            if strs[i].startswith(searchWord):
                break
            i += 1
        return i + 1 if i < n else -1
