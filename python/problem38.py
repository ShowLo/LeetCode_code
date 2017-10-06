public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countPrev(countAndSay(n - 1));
    }

    private String countPrev(String s) {
        int length = s.length();
        if (length == 1) {
            return ("1" + s.charAt(0));
        }
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for (int i = 1; i < length; ++i) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
                if (i == length - 1) {
                    sb.append("1").append(s.charAt(length - 1));
                }
            }
            else {
                ++count;
                if (i == length - 1) {
                    sb.append(count).append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}