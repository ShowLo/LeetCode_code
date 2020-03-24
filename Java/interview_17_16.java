class Solution {
   
    public int massage(int[] nums) {
        int dp_i_0 = 0, dp_i_1 = 0;
        for (int n : nums) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1);
            dp_i_1 = n + tmp;
        }
        return Math.max(dp_i_0, dp_i_1);
    }
}
