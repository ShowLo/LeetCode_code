class Solution {
    private char[] chars;
    private int maxLength(int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        chars = s.toCharArray();
        int middleIdx = 0, maxLen = 0;
        for (int i = 0; i < chars.length; ++i) {
            int longer = Math.max(maxLength(i, i), maxLength(i, i + 1));
            if (longer > maxLen) {
                maxLen = longer;
                middleIdx = i;
            }
        }
        int startIdx = maxLen % 2 == 0 ? middleIdx - maxLen / 2 + 1 : middleIdx - maxLen / 2;
        
        return new String(chars, startIdx, maxLen);
    }
}
