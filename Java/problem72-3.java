class Solution {

    public int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[] dp = new int[char2.length + 1];

        for (int j = 1; j <= char2.length; ++j) {
            dp[j] = j;
        }

        for (int i = 1; i <= char1.length; ++i) {
            int dp_ij_1 = i - 1;
            dp[0] = i;
            for (int j = 1; j <= char2.length; ++j) {
                int temp = dp[j];
                if (char1[i - 1] == char2[j - 1]) {
                    dp[j] = dp_ij_1;
                }
                else {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), dp_ij_1);
                }
                dp_ij_1 = temp;
            }
        }

        return dp[char2.length];
    }
}
