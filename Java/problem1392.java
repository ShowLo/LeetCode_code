class Solution {
    
    public String longestPrefix(String s) {
        char[] chars = s.toCharArray();
        int L = chars.length;
        int[] next = new int[L + 1];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < chars.length) {
            if (k == -1 || chars[j] == chars[k]) {
                next[++j] = ++k;
            }
            else {
                k = next[k];
            }
        }
        return next[L] == -1 ? "" : s.substring(0, next[L]);
    }
}
