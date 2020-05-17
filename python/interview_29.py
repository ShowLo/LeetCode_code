class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        row = len(matrix)
        if row == 0:
            return []
        col = len(matrix[0])
        if col == 0:
            return []
        result = []
        top, bottom = 0, row - 1
        left, right = 0, len(matrix[0]) - 1
        count = row * col
        idx = 0
        while idx < count:
            for j in range(left, right + 1):
                result.append(matrix[top][j])
                idx += 1
            if idx >= count:
                break
            top += 1
            for i in range(top, bottom + 1):
                result.append(matrix[i][right])
                idx += 1
            if idx >= count:
                break
            right -= 1
            for j in range(right, left - 1, -1):
                result.append(matrix[bottom][j])
                idx += 1
            if idx >= count:
                break
            bottom -= 1
            for i in range(bottom, top - 1, -1):
                result.append(matrix[i][left])
                idx += 1
            left += 1
        return result
        
