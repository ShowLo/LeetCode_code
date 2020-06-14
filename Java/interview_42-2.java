class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int dp = nums[0];
        int result = dp;
        for (int i = 1; i < N; ++i) {
            dp = Math.max(dp + nums[i], nums[i]);
            result = Math.max(result, dp);
        }
        return result;
    }
}
