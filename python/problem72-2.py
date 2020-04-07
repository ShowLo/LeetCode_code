class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        len1 = len(word1)
        len2 = len(word2)
        dp = [i for i in range(len2 + 1)]
        
        for i in range(1, len1 + 1):
            dp_ij_1 = dp[0]
            dp[0] = i
            for j in range(1, len2 + 1):
                temp = dp[j]
                if word1[i - 1] == word2[j - 1]:
                    dp[j] = dp_ij_1
                else:
                    dp[j] = 1 + min(dp[j - 1], dp[j], dp_ij_1)
                dp_ij_1 = temp
        return dp[len2]
