class Solution {
    public int cuttingRope(int n) {
        int result = 0;
        for (int i = 2; i <= n; ++i) {
            int ave = n / i;
            int res = n % i;
            int cur = (int)(Math.pow(ave, i - res) * Math.pow(ave + 1, res));
            result = Math.max(result, cur);
        }
        return result;
    }
}
