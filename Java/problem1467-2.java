class Solution {
    
    public double getProbability(int[] balls) {
        int k = balls.length;
        int[] cursum = new int[k];
        int m = 0;
        for (int i = 0; i < balls.length; ++i) {
            m += balls[i];
            cursum[i] = m;
        }
        double[] factorial = new double[m + 1];
        factorial[0] = 1.0;
        for (int i = 1; i <= m; ++i) {
            factorial[i] = i * factorial[i - 1];
        }
        int n = m / 2;
        // dp[h][i][j]: 对于前h种颜色的球，第一个盒子共i个球，且颜色数比第二个盒子的多j-k种的排列数
        double[][][] dp = new double[k][n + 1][k * 2 + 1];
        for (int i = 0; i <= n; ++i) {
            int t = i == 0 ? -1 : (i == balls[0] ? 1 : 0);
            t += k;
            dp[0][i][t] = 1.0;
        }
        for (int h = 1; h < k; ++h) {
            for (int x = 0; x <= balls[h]; ++x) {
                int t = x == 0 ? -1 : (x == balls[h] ? 1 : 0);
                // 接下来尝试对各种情况，往第一个盒子里放x个球
                for (int i = 0; i <= n - x; ++i) {
                    if (cursum[h] < i + balls[h]) {
                        break;
                    }
                    for (int j = Math.max(-t, 0); j <= k * 2; ++j) {
                        if (dp[h - 1][i][j] == 0) {
                            continue;
                        }
                        double pro = dp[h - 1][i][j];
                        pro *= factorial[i + x] / (factorial[x] * factorial[i]);
                        pro *= factorial[cursum[h] - i - x] / (factorial[balls[h] - x] * factorial[cursum[h] - i - balls[h]]);
                        dp[h][i + x][j + t] += pro;
                    }
                }
            }
        }
        double total = factorial[m];
        for (int b : balls) {
            total /= factorial[b];
        }
        return dp[k - 1][n][k] / total;
    }
}
