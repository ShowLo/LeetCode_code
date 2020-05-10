class Solution {
    private char[] chars;

    private boolean isDigits(int start, int end, boolean prev) {
        if (start >= chars.length || end >= chars.length || start > end) {
            return false;
        }
        if (chars[start] == '+' || chars[start] == '-') {
            return isDigits(start + 1, end, prev);
        }
        if (!(Character.isDigit(chars[start]) || (chars[start] == '.' && end - start >= 1))) {
            return false;
        }
        boolean findPoint = prev == false;
        for (int i = start; i <= end; ++i) {
            if (chars[i] == '.') {
                if (findPoint) {
                    return false;
                }
                else {
                    findPoint = true;
                }
            }
            else if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNumber(String s) {
        chars = s.strip().toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int end1 = 0;
        while (end1 < chars.length && chars[end1] != 'e' && chars[end1] != 'E') {
            ++end1;
        }
        --end1;
        if (end1 == chars.length - 1) {
            return isDigits(0, end1, true);
        }
        else {
            return isDigits(0, end1, true) && isDigits(end1 + 2, chars.length - 1, false);
        }
    }
}
