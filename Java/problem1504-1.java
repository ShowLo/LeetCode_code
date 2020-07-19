class Solution {
    public int numSubmat(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 0) {
                    continue;
                }
                mat[i][j] = mat[i - 1][j] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int minHeight = mat[i][j];
                int left = j;
                while (left >= 0 && mat[i][left] > 0) {
                    minHeight = Math.min(minHeight, mat[i][left--]);
                    result += minHeight;
                }
            }
        }
        return result;
    }
}
