class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        for (int i = chars.length; i > 1; --i) {
            for (int j = 0; j <= chars.length - i; ++j) {
                boolean match = true;
                for (int k = 0; k < i / 2; ++k) {
                    if (chars[j + k] != chars[j + i - k - 1]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return new String(chars, j, i);
                }
            }
        }
        return new String(chars, 0, 1);
    }
}
