class Solution {
    
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray(), pChar = p.toCharArray();
        int m = sChar.length, n = pChar.length;
        // dp[i][j]: s的前i个与p的前j个是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // s为空的时候p必须是a*b*c*的形式才能匹配成功
        for (int j = 2; j <= n; j += 2) {
            if (pChar[j - 1] == '*') {
                dp[0][j] = true;
            }
            else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (pChar[j - 1] != '*') {
                    // 不为*的情况，是否匹配成功取决于当前字符是否相同及去掉当前字符之后前面的字符串是否匹配成功
                    dp[i][j] = (pChar[j - 1] == '.' || pChar[j - 1] == sChar[i - 1]) && dp[i - 1][j - 1];
                }
                else {
                    // 为*的情况，分为匹配0个及多个的情况（需要字符匹配上）
                    if (j >= 2) {
                        // 匹配0个或至少一个
                        dp[i][j] = dp[i][j - 2] || ((pChar[j - 2] == '.' || sChar[i - 1] == pChar[j - 2]) && dp[i -1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
