class Solution {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] count0 = new int[N - 1];
        int[] count1 = new int[N - 1];
        
        for (int i = 0, count = 0; i < N - 1; ++i) {
            if (chars[i] == '0') {
                count0[i] = ++count;
            }
            else {
                count0[i] = count;
            }
        }
        for (int i = N - 2, count = 0; i >= 0; --i) {
            if (chars[i + 1] == '1') {
                count1[i] = ++count;
            }
            else {
                count1[i] = count;
            }
        }
        int result = 0;
        for (int i = 0; i < N - 1; ++i) {
            result = Math.max(result, count0[i] + count1[i]);
        }
        return result;
    }
}
