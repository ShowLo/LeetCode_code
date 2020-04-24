class Solution {
    public int numOfArrays(int n, int m, int k) {
        if (k == 0 || m < k) {
            return 0;
        }
        int mod = 1000_000_007;
        // dp[i][j][p]:前i个数，最大的为j，search cost为p
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i][1][1] = 1;
        }
        for (int j = 1; j <= m; ++j) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int p = 1; p <= k; ++p) {
                int sum = 0;
                for(int j = 2; j <= m; ++j) {
                    sum = (sum + dp[i - 1][j - 1][p - 1]) % mod;
                    int temp = (int)((dp[i - 1][j][p] * 1L * j) % mod);
                    dp[i][j][p] = (sum + temp) % mod;
                }
            }
        }
        int result = 0;
        for (int j = 1; j <= m; ++j) {
            result = (result + dp[n][j][k]) % mod;
        }
        return result % mod;
    }
}
