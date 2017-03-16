class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max = 0;
        substr = '';
        for ss in s:
            pos = substr.find(ss);
            if pos == -1:
                substr = substr + ss;
                length = len(substr);
                if length > max:
                    max = length;
            else:
                if pos == len(substr) - 1:
                    substr = ss;
                else:
                    substr = substr[pos + 1:] + ss;
        return max;