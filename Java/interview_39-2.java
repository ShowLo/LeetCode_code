class Solution {
    public int majorityElement(int[] nums) {
        int mostOffen = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                mostOffen = n;
                ++count;
            }
            else if (mostOffen == n) {
                ++count;
            }
            else {
                --count;
            }
        }
        return mostOffen;
    }
}
