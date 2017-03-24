class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # using Manacher Algorithm
        length = len(s);
        if length == 1:
            return s;
        newLen = length * 2 + 1;
        maxLen = 0;
        str = "";
        for i in range(newLen):
            if i % 2 == 0:
                str += "#";
            else:
                str += s[(i - 1) // 2];
        L = [1] * newLen;
        L[1] = 2;
        maxID = 1;
        maxRight = 3;
        for i in range(2, newLen - 1):
            if L[maxID] > 1 and i < maxRight:
                j = 2 * maxID - i;
                d = maxRight - i - L[j];
                if d == 0:
                    L[i] = L[j];
                    while i + L[i] < newLen and i - L[i] >= 0 and str[i + L[i]] == str[i - L[i]]:
                        L[i] += 1;
                    if i + L[i] >= maxRight:
                        maxID = i;
                        maxRight = i + L[i];
                else:
                    L[i] = min(L[j], maxRight - i);
            else:
                while i + L[i] < newLen and i - L[i] >= 0 and str[i + L[i]] == str[i - L[i]]:
                    L[i] += 1;
                if i + L[i] >= maxRight:
                    maxID = i;
                    maxRight = i + L[i];
        maxIndex = L.index(max(L));
        maxLen = L[maxIndex];
        if maxIndex % 2 == 0:
            return s[maxIndex // 2 - (maxLen - 1) // 2: maxIndex // 2 + (maxLen - 1) // 2];
        else:
            return s[(maxIndex - 1) // 2 - maxLen // 2 + 1: (maxIndex - 1) // 2 + maxLen // 2];