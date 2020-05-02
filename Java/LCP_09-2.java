class Solution {
    public int minJump(int[] jump) {
        // dp[i]:从i跳出N-1需要的最少次数\
        int N = jump.length;
        int[] dp = new int[N];
        for (int i = N - 1; i >= 0; --i) {
            if (i + jump[i] >= N) {
                dp[i] = 1;
            }
            else {
                dp[i] = dp[i + jump[i]] + 1;
            }
            for (int j = i + 1; j < N && dp[j] >= dp[i] + 1; ++j) {
                // j位置上的可以先跳回到i再通过i跳出N-1，遍历到dp[j] < dp[i] + 1为止
                // 因为在这个j之后的dp都可以通过跳到j再跳出N-1，次数(dp[j] + 1 < dp[i] + 1)不会比跳回i更多
                dp[j] = dp[i] + 1;
            }
        }
        return dp[0];
    }
}
