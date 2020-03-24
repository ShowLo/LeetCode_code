class Solution {
    private int gcd(int x, int y) {
        while (true) {
            if (x % y == 0) {
                return y;
            }
            else {
                int temp = y;
                y = x % y;
                x = temp;
            }
        }
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || z == x + y;
        }
        int n = x > y ? gcd(x, y) : gcd(y, x);
        return z % n == 0;
    }
}
