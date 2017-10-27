class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        sLen = len(s)
        lastLen = 0
        for i in range(sLen - 1, -1, -1):
            if s[i] != ' ':
                lastLen += 1
            elif lastLen != 0:
                return lastLen
        return lastLen