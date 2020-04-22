class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int p = n / 3;
        int q = n % 3;
        if (q == 2) {
            return (int)Math.pow(3, p) * 2;
        }
        if (q == 1) {
            return (int)Math.pow(3, p - 1) * 4;
        }
        return (int)Math.pow(3, p);
    }
}
