class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double extra = myPow(x, n % 2);
        return half * half * extra;
    }
}
