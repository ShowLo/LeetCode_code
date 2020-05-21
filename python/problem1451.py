class Solution:
    def arrangeWords(self, text: str) -> str:
        strs = text.split()
        strs[0] = strs[0].lower()
        strs.sort(key = lambda x : len(x))
        strs[0] = strs[0].capitalize()
        return ' '.join(strs)
