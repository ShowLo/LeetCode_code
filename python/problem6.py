class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s;
        result = "";
        temp = ["" for n in range(numRows)];
        for i in range(len(s)):
            t = i % (numRows * 2 - 2);
            index = numRows - 1 - abs(t - numRows + 1);
            temp[index] += s[i];
        for n in range(numRows):
            result += temp[n];
        return result;