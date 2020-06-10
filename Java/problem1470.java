class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int half = nums.length / 2;
        for (int i = 0; i < half; ++i) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + half];
        }
        return result;
    }
}
