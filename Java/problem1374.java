class Solution {
    public String generateTheString(int n) {
        StringBuilder s = new StringBuilder("a");
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; ++i) {
                s.append("b");
            }
        }
        else {
            for (int i = 0; i < n - 1; ++i) {
                s.append("a");
            }
        }
        return s.toString();
    }
}
