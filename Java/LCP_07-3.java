class Solution {
    
    public int numWays(int n, int[][] relation, int k) {
        // dp[i][j]: 用j步走到i的方案数
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int j = 1; j <= k; ++j) {
            for (int i = 0; i < n; ++i) {
                for (int[] r : relation) {
                    if (r[1] == i) {
                        dp[r[1]][j] += dp[r[0]][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][k];
    }
}
