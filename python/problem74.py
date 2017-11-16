class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        row = len(matrix)
        col = len(matrix[0])
        colMark = set()
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 0:
                    colMark.add(j)
                    for c in range(j):
                        matrix[i][c] = 0
                    for c in range(j + 1, col):
                        if matrix[i][c] == 0:
                            colMark.add(c)
                        else:
                            matrix[i][c] = 0
                    break
        for c in colMark:
            for r in range(row):
                matrix[r][c] = 0