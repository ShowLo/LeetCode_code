class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row = len(matrix)
        if row == 0:
            return False
        col = len(matrix[0])
        if col == 0:
            return False
        targetRow = -1
        for i in range(row):
            if matrix[i][0] > target:
                targetRow = i - 1
                break
            elif matrix[i][col - 1] >= target:
                targetRow = i
                break
        if targetRow == -1:
            return False
        for i in range(col):
            if matrix[targetRow][i] == target:
                return True
            elif matrix[targetRow][i] > target:
                return False
        return False