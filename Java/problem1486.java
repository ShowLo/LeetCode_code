class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        int num = start;
        for (int i = 1; i < n; ++i) {
            num += 2;
            result ^= num;
        }
        return result;
    }
}
