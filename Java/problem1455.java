class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        int i = 0;
        for (; i < strs.length; ++i) {
            if (strs[i].startsWith(searchWord)) {
                break;
            }
        }
        if (i < strs.length) {
            return i + 1;
        }
        return -1;
    }
}
