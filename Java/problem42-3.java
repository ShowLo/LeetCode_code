class Solution {

    public int trap(int[] height) {
        int N = height.length;
        if (N <= 2) {
            return 0;
        }
        int left = 0, left_max = height[0];
        int right = N - 1, right_max = height[N - 1];

        int result = 0;
        while (left < right) {
            if (left_max < right_max) {
                result += left_max - height[left];
                left_max = Math.max(left_max, height[++left]);
            }
            else {
                result += right_max - height[right];
                right_max = Math.max(right_max, height[--right]);
            }
        }

        return result;
    }
}
