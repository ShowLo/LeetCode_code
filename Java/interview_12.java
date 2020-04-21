class Solution {
    private boolean[][] visited;
    private char[] words;
    private int row;
    private int col;

    private boolean dfs(char[][] board, int i, int j, int targetIdx) {
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j] || board[i][j] != words[targetIdx]) {
            return false;
        }
        if (targetIdx == words.length - 1) {
            return true;
        }
        else {
            // 标记访问
            visited[i][j] = true;
            // 注意这里四个要并列，以实现剪枝（一旦有一个返回true后面的就不用执行了）
            boolean find = dfs(board, i, j - 1, targetIdx + 1) || dfs(board, i, j + 1, targetIdx + 1)
                || dfs(board, i - 1, j, targetIdx + 1) || dfs(board, i + 1, j, targetIdx + 1);
            // 回溯，标记为未访问
            visited[i][j] = false;
            return find;
        }

    }
    public boolean exist(char[][] board, String word) {
        words = word.toCharArray();
        row = board.length;
        col = board[0].length;
        if (words.length > row * col) {
            return false;
        }
        visited = new boolean[row][col];
        boolean result = false;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (dfs(board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
