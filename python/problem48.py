class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        size = len(matrix)
        #先沿对角线翻转
        for row in range(size):
            for col in range(size - row):
                matrix[row][col], matrix[size - 1 - col][size - 1 - row] = matrix[size - 1 - col][size - 1 - row], matrix[row][col]
        #再沿中线翻转
        for row in range(size//2):
            for col in range(size):
                matrix[row][col], matrix[size - 1 - row][col] = matrix[size - 1 - row][col], matrix[row][col]