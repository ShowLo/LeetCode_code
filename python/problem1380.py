class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        row = len(matrix)
        col = len(matrix[0])
        recordMin = [[False for _ in range(col)] for _ in range(row)]
        result = []
        for i in range(row):
            minJ = 0
            for j in range(1, col):
                if matrix[i][j] < matrix[i][minJ]:
                    minJ = j
            recordMin[i][minJ] = True
        for j in range(col):
            maxI = 0
            for i in range(1, row):
                if matrix[i][j] > matrix[maxI][j]:
                    maxI = i
            if recordMin[maxI][j]:
                result.append(matrix[maxI][j])
        return result
