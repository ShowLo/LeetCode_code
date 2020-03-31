class Solution {
    public int lastRemaining(int n, int m) {
        int result = 0;
        for (int i = 2; i <= n; ++i) {
            result = (result + m) % i;
        }
        return result;
    }
}
