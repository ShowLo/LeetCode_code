class TreeAncestor {
    private int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        // dp[i][j]: 距离节点i距离为2^j的节点
        dp = new int[n][16];
        Arrays.fill(dp[0], -1);
        for (int i = 1; i < parent.length; ++i) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = parent[i];
            for (int j = 1; j < 16; ++j) {
                // 2^j = 2^(j-1) * 2^(j-1)
                dp[i][j] = dp[dp[i][j - 1]][j - 1];
                if (dp[i][j] < 0) {
                    break;
                }
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
                node = dp[node][j];
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
