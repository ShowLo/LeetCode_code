class Solution {
    private int[] charNum;

    private boolean fromWords(String str) {
        int[] tmp = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            int item = (int)str.charAt(i) - (int)'a';
            if (++tmp[item] > charNum[item]) {
                return false;
            }
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        charNum = new int[26];
        for (int i = 0; i < chars.length(); ++i) {
            char item = chars.charAt(i);
            ++charNum[(int)item - (int)'a'];
        }
        int sumLen = 0;
        for (String w : words) {
            if (fromWords(w)) {
                sumLen += w.length();
            }
        }
        return sumLen;
    }
}
