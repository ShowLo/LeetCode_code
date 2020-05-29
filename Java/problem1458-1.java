class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        // dp[i][j]: nums1前i与nums2前j之间的最大点积
        dp[0][0] = nums1[0] * nums2[0];
        int max = nums1[0];
        int min = nums1[0];
        for (int i = 1; i < m; ++i) {
            max = Math.max(nums1[i], max);
            min = Math.min(nums1[i], min);
            if (nums2[0] > 0) {
                dp[i][0] = max * nums2[0];
            }
            else {
                dp[i][0] = min * nums2[0];
            }
        }
        max = nums2[0];
        min = nums2[0];
        for (int j = 1; j < n; ++j) {
            max = Math.max(nums2[j], max);
            min = Math.min(nums2[j], min);
            if (nums1[0] > 0) {
                dp[0][j] = max * nums1[0];
            }
            else {
                dp[0][j] = min * nums1[0];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(Math.max(nums1[i] * nums2[j], Math.max(dp[i - 1][j - 1], dp[i - 1][j - 1] + nums1[i] * nums2[j])), Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m - 1][n - 1];
    }
}
