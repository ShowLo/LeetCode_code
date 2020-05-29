class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m < n) {
            return maxDotProduct(nums2, nums1);
        }
        int[] dp = new int[n];
        // 第i次循环中的dp[j]: nums1前i与nums2前j之间的最大点积
        dp[0] = nums1[0] * nums2[0];
        int max = nums2[0];
        int min = nums2[0];
        for (int j = 1; j < n; ++j) {
            max = Math.max(nums2[j], max);
            min = Math.min(nums2[j], min);
            if (nums1[0] > 0) {
                dp[j] = max * nums1[0];
            }
            else {
                dp[j] = min * nums1[0];
            }
        }
        max = nums1[0];
        min = nums1[0];
        int dp_i_1_j_1;
        for (int i = 1; i < m; ++i) {
            max = Math.max(max, nums1[i]);
            min = Math.min(min, nums1[i]);
            dp_i_1_j_1 = dp[0];
            if (nums2[0] > 0) {
                dp[0] = max * nums2[0];
            }
            else {
                dp[0] = min * nums2[0];
            }
            for (int j = 1; j < n; ++j) {
                int tmp = dp[j];
                dp[j] = Math.max(Math.max(nums1[i] * nums2[j], Math.max(dp_i_1_j_1, dp_i_1_j_1 + nums1[i] * nums2[j])), Math.max(tmp, dp[j - 1]));
                dp_i_1_j_1 = tmp;
            }
        }
        return dp[n - 1];
    }
}
