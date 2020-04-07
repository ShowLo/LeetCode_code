class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i <= (N - 1) / 2; ++i) {
            for (int j = 0; j < N / 2; ++j) {
                int temp = matrix[N - 1 - j][i];
                matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
                matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
                matrix[j][N - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
