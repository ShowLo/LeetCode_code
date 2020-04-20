class Solution {
    
    public int numOfWays(int n) {
        int ABC = 6, ABA = 6;
        int mod = 1_000_000_007;
        for (int i = 1; i < n; ++i) {
            int temp = ABC;
            ABC = (int)((ABC * 2L + ABA * 2L) % mod);
            ABA = (int)((temp * 2L + ABA * 3L) % mod);
        }
        return (int)(ABC + ABA) % mod;
    }
}
