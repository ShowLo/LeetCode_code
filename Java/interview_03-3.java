class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return 0;
    }
}
