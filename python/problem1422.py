class Solution:
    def maxScore(self, s: str) -> int:
        N = len(s)
        count, result = 0, 0
        for i in range(N - 1):
            if s[i] == '0':
                count += 1
        for i in range(N - 1, 0, -1):
            if s[i] == '1':
                count += 1
            elif i < N - 1:
                count -= 1
            result = max(result, count)
        return result
