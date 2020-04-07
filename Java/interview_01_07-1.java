class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                copy[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                matrix[j][N - 1 - i] = copy[i][j];
            }
        }
    }
}
