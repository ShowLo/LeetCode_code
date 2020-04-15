class Solution {
    
    public String longestPalindrome(String s) {
        int L = s.length();
        if (L == 0) {
            return "";
        }
        char[] chars = new char[L * 2 + 3];
        int[] P = new int[L * 2 + 3];
        chars[0] = '^';
        chars[chars.length - 1] = '$';
        chars[chars.length - 2] = '#';
        for (int i = 0; i < L; ++i) {
            chars[2 * i + 1] = '#';
            chars[2 * i + 2] = s.charAt(i);
        }
        int center = 0, right = 0;
        int maxIdx = 0, maxLen = 0;
        for (int i = 1; i < chars.length - 1; ++i) {
            if (i < right) {
                P[i] = Math.min(P[2 * center - i], right - i);
            }
            else {
                P[i] = 0;
            }

            while (chars[i + P[i] + 1] == chars[i - P[i] - 1]) {
                ++P[i];
            }

            if (i + P[i] > right) {
                right = i + P[i];
                center = i;
            }

            if (P[i] > maxLen) {
                maxLen = P[i];
                maxIdx = i;
            }
        }
        int startIdx = (maxIdx - P[maxIdx] - 1) / 2;
        return s.substring(startIdx, startIdx + maxLen);
    }
}
