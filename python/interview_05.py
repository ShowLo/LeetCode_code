class Solution:
    def replaceSpace(self, s: str) -> str:
        result = ''
        for ss in s:
            if ss == ' ':
                result += '%20'
            else:
                result += ss
        return result
