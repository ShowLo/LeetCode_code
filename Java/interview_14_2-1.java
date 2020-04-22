class Solution {
    private int remainder(int num, int pow, int mod) {
        int result = 1;
        for (int i = 0; i < pow; ++i) {
            result = (int)(((long)(result % mod) * (long)(num % mod)) % mod);
        }
        return result;
    }
    public int cuttingRope(int n) {
        int mod = 1000_000_007;
        if (n <= 3) {
            return n - 1;
        }
        int p = n / 3;
        int q = n % 3;
        if (q == 2) {
            return (int)((remainder(3, p, mod) * 2L) % mod);
        }
        if (q == 1) {
            return (int)((remainder(3, p - 1, mod) * 4L) % mod);
        }
        return remainder(3, p, mod);
    }
}
