class Solution {

    public int trap(int[] height) {
        int N = height.length;
        if (N <= 2) {
            return 0;
        }
        int[] left_max = new int[N];
        int[] right_max = new int[N];

        left_max[0] = height[0];
        for (int i = 1; i < N; ++i) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < N; ++i) {
            result += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return result;
    }
}
