class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 3];
        int idx = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ' ') {
                result[idx++] = '%';
                result[idx++] = '2';
                result[idx++] = '0';
            }
            else {
                result[idx++] = chars[i];
            }
        }
        return new String(result, 0, idx);
    }
}
