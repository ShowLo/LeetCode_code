class Solution {
    
    public int ways(String[] pizza, int k) {
        int mod = 1000_000_007;
        int row = pizza.length;
        int col = pizza[0].length();
        // cumSum[i][j]：以(i,j)为左上角的披萨里有多少个苹果
        int[][] cumSum = new int[row][col];
        cumSum[row - 1][col - 1] = pizza[row - 1].charAt(col - 1) == 'A' ? 1 : 0;
        for (int j = col - 2; j >= 0; --j) {
            if (pizza[row - 1].charAt(j) == 'A') {
                cumSum[row - 1][j] = cumSum[row - 1][j + 1] + 1;
            }
            else {
                cumSum[row - 1][j] = cumSum[row - 1][j + 1];
            }
        }
        for (int i = row - 2; i >= 0; --i) {
            int curcum = 0;
            for (int j = col - 1; j >= 0; --j) {
                curcum += pizza[i].charAt(j) == 'A' ? 1 : 0;
                cumSum[i][j] = cumSum[i + 1][j] + curcum;
            }
        }

        // dp[i][j][p]:切了p-1刀后剩下第p块且其以(i,j)为左上角的披萨的方案数
        int[][][] dp = new int[row][col][k];
        dp[0][0][0] = 1;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // 只需要切k-1次就得到k块
                for (int p = 1; p < k; ++p) {
                    // 第p-2刀切了之后剩下的是(i, jj)
                    for (int jj = 0; jj < j; ++jj) {
                        // 需要确保切了第p-2刀之后还可以再竖切一刀剩下(i,j)
                        if (cumSum[i][j] > 0 && cumSum[i][jj] - cumSum[i][j] > 0) {
                            dp[i][j][p] = (dp[i][j][p] + dp[i][jj][p - 1]) % mod;
                        }
                    }
                    // 第p-2刀切了之后剩下的是(ii, j)
                    for (int ii = 0; ii < i; ++ii) {
                        if (cumSum[i][j] > 0 && cumSum[ii][j] - cumSum[i][j] > 0) {
                            // 需要确保切了第p-2刀之后还可以再切一刀剩下(i,j)
                            dp[i][j][p] = (dp[i][j][p] + dp[ii][j][p - 1]) % mod;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                result = (result + dp[i][j][k - 1]) % mod;
            }
        }
        return result;
    }
}
