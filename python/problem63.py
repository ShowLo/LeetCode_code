class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        paths = [[0] * n for i in range(m)]
        for i in range(n):
            if obstacleGrid[0][i] != 1:
                paths[0][i] = 1
            else:
                break
        for i in range(m):
            if obstacleGrid[i][0] != 1:
                paths[i][0] = 1
            else:
                break
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] != 1:
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
        return paths[m - 1][n - 1]