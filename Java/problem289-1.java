class Solution {
    private int[][] copy;

    private int count(int i, int j) {
        int num = 0;
        for (int m = Math.max(0, i - 1); m <= Math.min(copy.length - 1, i + 1); ++m) {
            for (int n = Math.max(0, j - 1); n <= Math.min(copy[0].length - 1, j + 1); ++n) {
                if (copy[m][n] == 1) {
                    ++num;
                }
            }
        }
        return num - copy[i][j];
    }
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        copy = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int onesCount = count(i, j);
                if (copy[i][j] == 0 && onesCount == 3) {
                    board[i][j] = 1;
                }
                else if (copy[i][j] == 1 && (onesCount < 2 || onesCount > 3)) { 
                    board[i][j] = 0;
                }
            }
        }
    }
}
