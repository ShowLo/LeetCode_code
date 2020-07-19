class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        height = mat#copy.deepcopy(mat)
        row, col = len(mat), len(mat[0])
        for i in range(1, row):
            for j in range(col):
                if height[i][j] == 1:
                    height[i][j] = height[i - 1][j] + 1
        result = 0
        for i in range(row):
            for j in range(col):
                if height[i][j] == 0:
                    continue
                left = j
                minHeight = height[i][j]
                while left >= 0 and height[i][left] > 0:
                    result += minHeight
                    left -= 1
                    minHeight = min(minHeight, height[i][left])
        return result
