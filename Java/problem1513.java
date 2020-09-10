class Solution {
    public int numSub(String s) {
        int MOD = 1000_000_007;
        int res = 0;
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ++oneCount;
            }
            else {
                res = (res + (int)(((long)oneCount * (long)(oneCount + 1)) % MOD) / 2) % MOD;
                oneCount = 0;
            }
        }
        res = (res + (int)(((long)oneCount * (long)(oneCount + 1)) % MOD) / 2) % MOD;
        return res;
    }
}
