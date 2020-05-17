class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int totalCount = row * col;
        int[] result = new int[totalCount];
        if (totalCount == 0) {
            return result;
        }
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int idx = 0;
        while (idx < totalCount) {
            for (int j = left; j <= right; ++j) {
                result[idx++] = matrix[top][j];
            }
            ++top;
            if (idx >= totalCount) {
                break;
            }
            for (int i = top; i <= bottom; ++i) {
                result[idx++] = matrix[i][right];
            }
            --right;
            if (idx >= totalCount) {
                break;
            }
            for (int j = right; j >= left; --j) {
                result[idx++] = matrix[bottom][j];
            }
            --bottom;
            if (idx >= totalCount) {
                break;
            }
            for (int i = bottom; i >= top; --i) {
                result[idx++] = matrix[i][left];
            }
            ++left;
        }
        return result;
    }
}
