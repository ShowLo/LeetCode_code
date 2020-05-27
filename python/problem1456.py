class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        index = [-1] * 26
        base = ord('a')
        index[ord('a') - base] = 0
        index[ord('e') - base] = 1
        index[ord('i') - base] = 2
        index[ord('o') - base] = 3
        index[ord('u') - base] = 4
        curSum = 0
        for i in range(k):
            idx = index[ord(s[i]) - base]
            if idx != -1:
                curSum += 1
        result = curSum
        for i in range(k, len(s)):
            left = index[ord(s[i - k]) - base]
            right = index[ord(s[i]) - base]
            if left == -1 and right != -1:
                curSum += 1
                result = max(curSum, result)
            elif left != -1 and right == -1:
                curSum -= 1
        return result
