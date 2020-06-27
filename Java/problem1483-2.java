class TreeAncestor {
    private int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        // dp[i][j]: 距离节点j距离为2^i的节点
        int bits = (int)Math.ceil(Math.log(n * 1.0) / Math.log(2));
        dp = new int[bits][n];
        for (int j = 0; j < n; ++j) {
            dp[0][j] = parent[j];
        }
        for (int i = 1; i < bits; ++i) {
            for (int j = 0; j < n; ++j) {
                // 2^i = 2^(i-1) * 2^(i-1)
                dp[i][j] = dp[i - 1][j] == -1 ? -1 : dp[i - 1][dp[i - 1][j]];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int j = 0;
        while (k > 0) {
            if (node < 0) {
                return -1;
            }
            if ((k & 1) == 1) {
                node = dp[j][node];
            }
            ++j;
            k >>>= 1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
