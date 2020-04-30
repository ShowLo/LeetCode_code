class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        int result = dp[0];

        int[] deque = new int[N];
        deque[0] = 0;
        int left = 0, right = 0;

        for (int i = 1; i < N; ++i) {
            dp[i] = nums[i];
            if (dp[deque[left]] > 0) {
                dp[i] = nums[i] + dp[deque[left]];
            }
            while (right - left >= 0 && dp[deque[right]] < dp[i]) {
                --right;
            }
            deque[++right] = i;
            if (i - deque[left] >= k) {
                ++left;
            }    
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
