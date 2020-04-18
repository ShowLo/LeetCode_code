class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int F0 = 0, F1 = 1;
        for (int i = 2; i <= n; ++i) {
            int temp = F1;
            F1 = (F0 + F1) % 1000_000_007;
            F0 = temp;
        }
        return F1;
    }
}
