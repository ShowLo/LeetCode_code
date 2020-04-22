class Solution {
    
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = 1000_000_007;
        int result = 1;
        while (n > 4) {
            result = (int)((result * 3L) % mod);
            n -= 3;
        }
        result = (int)((result * 1L * n) % mod);
        return result;
    }
}
