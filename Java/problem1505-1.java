class Solution {
    public String minInteger(String num, int k) {
        if (k == 0 || num == null) {
            return num;
        }
        for (int i = 0; i <= 9; ++i) {
            int idx = num.indexOf(String.valueOf(i));
            if (idx >= 0 && idx <= k) {
                return String.valueOf(i) + minInteger(num.substring(0, idx) + num.substring(idx + 1, num.length()), k - idx);
            }
        }
        return num;
    }
}
