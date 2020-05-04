class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            // n取到整数最小值的话直接取反会溢出，所以这里需要除以2
            if ((n & 1) == 0) {
                double tmp = myPow(1 / x, -(n / 2));
                return tmp * tmp;
            }
            else {
                double tmp = myPow(1 / x, -(n / 2));
                return tmp * tmp / x;
            }
        }
        double result = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }
}
