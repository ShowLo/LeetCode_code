class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1, i;
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                prev = i;
                break;
            }
        }
        for (++i; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (i - prev <= k) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
