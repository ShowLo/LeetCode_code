class Solution:
    def longestPalindrome(self, s: str) -> str:
        extendStr = '^'
        for ss in s:
            extendStr += '#' + ss
        extendStr += '#$'

        P = [0 for _ in range(len(extendStr))]
        center, right = 0, 0
        maxIdx, maxLen = 0, 0

        for i in range(1, len(extendStr) - 1):
            if i < right:
                P[i] = min(P[2 * center - i], right - i)
            else:
                P[i] = 0
            
            while extendStr[i - P[i] - 1] == extendStr[i + P[i] + 1]:
                P[i] += 1

            if i + P[i] > right:
                right = i + P[i]
                center = i

            if P[i] > maxLen:
                maxLen = P[i]
                maxIdx = i
        
        startIdx = (maxIdx - P[maxIdx] - 1) // 2
        return s[startIdx : startIdx + maxLen]
