class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int N = chars.length;
        // dp[i][j]表示从i到j这一段是回文串
        boolean[][] dp = new boolean[N][N];
        int left = 0, maxLen = 0;
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i; j < N; ++j) {
                dp[i][j] = (chars[i] == chars[j]) && (j - 1 < i + 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    left = i;
                }
            }
        }
        return new String(chars, left, maxLen);
    }
}
