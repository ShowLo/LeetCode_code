class Solution {
    private int count;
    private boolean[][] visited;
    private int row;
    private int col;
    private int limit;

    private void visit(int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int sum = i % 10 + i / 10 + j % 10 + j / 10;
        if (sum <= limit) {
            ++count;
            visit(i + 1, j);
            visit(i, j + 1);
        }

    }
    public int movingCount(int m, int n, int k) {
        count = 0;
        visited = new boolean[m][n];
        row = m;
        col = n;
        limit = k;
        visit(0, 0);
        return count;
    }
}
