class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int sLen1 = str1.length(), sLen2 = str2.length();
        if (sLen1 < sLen2) {
            return gcdOfStrings(str2, str1);
        }
        int n = sLen1 / sLen2;
        for (int i = 0; i < n; ++i) {
            if (!str2.equals(str1.substring(i * sLen2, (i + 1) * sLen2))) {
                return "";
            }
        }
        if (sLen1 % sLen2 == 0) {
            return str2;
        }
        return gcdOfStrings(str2, str1.substring(n * sLen2));
    }
}
