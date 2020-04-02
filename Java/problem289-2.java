class Solution {
    private final int zero2one = -1;
    private final int one2zero = 2;
    private int count(int[][] board, int i, int j) {
        int num = 0;
        for (int m = Math.max(0, i - 1); m <= Math.min(board.length - 1, i + 1); ++m) {
            for (int n = Math.max(0, j - 1); n <= Math.min(board[0].length - 1, j + 1); ++n) {
                if (board[m][n] >= 1) {
                    ++num;
                }
            }
        }
        return num - board[i][j];
    }
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int onesCount = count(board, i, j);
                if (board[i][j] == 0 && onesCount == 3) {
                    board[i][j] = zero2one;
                }
                else if (board[i][j] == 1 && (onesCount < 2 || onesCount > 3)) { 
                    board[i][j] = one2zero;
                }
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == one2zero) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == zero2one) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
