class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < n; ++i) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n];
        }
        return result;
    }
}
