class Solution {
    public int maxProduct(int[] nums) {
        int first = 0, second = 0;
        for (int n : nums) {
            if (n >= first) {
                int tmp = first;
                first = n;
                second = tmp;
            }
            else if (n >= second) {
                second = n;
            }
        }
        return (first - 1) * (second - 1);
    }
}
