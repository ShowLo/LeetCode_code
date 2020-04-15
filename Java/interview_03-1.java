class Solution {
    public int findRepeatNumber(int[] nums) {
        Set set = new HashSet();
        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }
        return 0;
    }
}
