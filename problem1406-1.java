class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int[] dp = new int[N + 1];
        dp[N] = 0;
        dp[N - 1] = stoneValue[N - 1];
        int sum = stoneValue[N - 1];
        if (N - 2 >= 0) {
            sum += stoneValue[N - 2];
            dp[N - 2] = sum - Math.min(dp[N - 1], dp[N]);
        }
        for (int i = N - 3; i >= 0; --i) {
            sum += stoneValue[i];
            dp[i] = sum - Math.min(Math.min(dp[i + 1], dp[i + 2]), dp[i + 3]);
        }
        if (dp[0] * 2 > sum) {
            return "Alice";
        }
        else if (dp[0] * 2 < sum) {
            return "Bob";
        }
        else {
            return "Tie";
        }
    }
}
