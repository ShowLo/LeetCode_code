class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]: 0~i这些房子分成了j+1个区，且第i个房子的颜色为k + 1
        int[][][] dp = new int[m][target][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < target; ++j) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        if (houses[0] != 0) {
            dp[0][0][houses[0] - 1] = 0;
        }
        else {
            for (int k = 0; k < n; ++k) {
                dp[0][0][k] = cost[0][k];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < target; ++j) {
                for (int k = 0; k < n; ++k) {
                    // 当前房子如果已经染过色了，花费不增加
                    if (houses[i] != 0 && houses[i] - 1 != k) {
                        continue;
                    }
                    int c = cost[i][k];
                    int color = k;
                    if (houses[i] != 0) {
                        c = 0;
                        color = houses[i] - 1;
                    }
                    // 遍历上一个房子可能的颜色，颜色相同时当前街区数不变，否则需要+1
                    int min = dp[i - 1][j][color];
                    if (j > 0) {
                        for (int p = 0; p < n; ++p) {
                            if (p == color) {
                                continue;
                            }
                            min = Math.min(min, dp[i - 1][j - 1][p]);
                        }
                    }
                    if (min != Integer.MAX_VALUE) {
                        dp[i][j][k] = Math.min(min + c, dp[i][j][k]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < n; ++k) {
            result = Math.min(dp[m - 1][target - 1][k], result);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
