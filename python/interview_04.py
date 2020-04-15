class Solution:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        row = len(matrix)
        if row == 0:
            return False
        col = len(matrix[0])
        if col == 0:
            return False
        i, j = 0, col - 1
        while i < row and j >= 0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                i += 1
            else:
                j -= 1
        return False
