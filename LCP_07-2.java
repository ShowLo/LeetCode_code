class Solution {
    private boolean[][] edges;
    private int count;
    
    private void visit(int id, int k, int n) {
        if (k == 0) {
            if (id == n - 1) {
                ++count;
            }
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (edges[id][i]) {
                visit(i, k - 1, n);
            }
        }
    }
    
    public int numWays(int n, int[][] relation, int k) {
        edges = new boolean[n][n];
        for (int[] r : relation) {
            edges[r[0]][r[1]] = true;
        }
        count = 0;
        visit(0, k, n);
        return count;
    }
}
