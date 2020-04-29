class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int L = N - k + 1;
        if (L <= 0) {
            return new int[0];
        }
        int[] result = new int[L];
        // 把整个数组分为k组，每个组都有一个左边界(i%k==0处)和右边界((i+1)%k==0处)
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            // 求当前数到左边界之间这一段的最大值
            if (i % k == 0) {
                curMax = Integer.MIN_VALUE;
            }
            curMax = Math.max(curMax, nums[i]);
            leftMax[i] = curMax;
        }
        curMax = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; --i) {
            // 求当前数到右边界之间这一段的最大值
            if ((i + 1) % k == 0) {
                curMax = Integer.MIN_VALUE;
            }
            curMax = Math.max(curMax, nums[i]);
            rightMax[i] = curMax;
        }
        for (int i = 0; i < L; ++i) {
            if (i % k == 0) {
                // 刚好整段k个数处于同一个分段里
                result[i] = rightMax[i];
            }
            else {
                result[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
            }
        }

        return result;
    }
}
