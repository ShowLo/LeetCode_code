class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        len1 = len(word1)
        len2 = len(word2)
        dis = [[0] * (len2 + 1) for i in range(len1 + 1)]
        #用动态规划，dis[i][j]代表word1[0:i]和word2[0:j]的最短距离
        for i in range(1, len1 + 1):
            dis[i][0] = i
        for i in range(1, len2 + 1):
            dis[0][i] = i
        for i in range(1, len1 + 1):
            for j in range(1, len2 + 1):
                if word1[i - 1] == word2[j - 1]:
                    dis[i][j] = dis[i - 1][j - 1]
                else:
                    #取替换、减、增这三种操作之后的最小距离
                    dis[i][j] = min(dis[i - 1][j - 1] + 1, dis[i - 1][j] + 1, dis[i][j - 1] + 1)
        return dis[len1][len2]