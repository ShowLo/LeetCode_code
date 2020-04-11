class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int dp0, dp1 = stoneValue[N - 1], dp2 = 0;
        int sum = stoneValue[N - 1];
        if (N - 2 >= 0) {
            sum += stoneValue[N - 2];
            dp0 = sum - Math.min(dp1, dp2);
        }
        else {
            dp0 = dp1;
        }
        for (int i = N - 3; i >= 0; --i) {
            sum += stoneValue[i];
            int temp = dp0;
            dp0 = sum - Math.min(Math.min(dp0, dp1), dp2);
            dp2 = dp1;
            dp1 = temp;
        }
        if (dp0 * 2 > sum) {
            return "Alice";
        }
        else if (dp0 * 2 < sum) {
            return "Bob";
        }
        else {
            return "Tie";
        }
    }
}
