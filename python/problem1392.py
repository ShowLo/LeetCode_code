class Solution:
    def longestPrefix(self, s: str) -> str:
        N = len(s)
        next = [-1 for _ in range(N + 1)]
        k = -1
        j = 0
        while j < N:
            if k == -1 or s[j] == s[k]:
                k += 1
                j += 1
                next[j] = k
            else:
                k = next[k]
        return s[0 : next[N]]
