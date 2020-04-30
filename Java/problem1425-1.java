class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        int result = dp[0];

        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);

        for (int i = 1; i < N; ++i) {
            dp[i] = nums[i];
            if (dp[deque.peekFirst()] > 0) {
                dp[i] = nums[i] + dp[deque.peekFirst()];
            }
            while (deque.size() > 0 && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
