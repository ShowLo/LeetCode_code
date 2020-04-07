class Solution {
    private int len1;
    private int len2;
    private int[][] record;

    private int distance(String word1, String word2, int idx1, int idx2) {
        if (idx1 == len1) {
            return len2 - idx2;
        }
        if (idx2 == len2) {
            return len1 - idx1;
        }
        if (record[idx1][idx2] > 0) {
            return record[idx1][idx2];
        }
        int result = 0;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            result = distance(word1, word2, idx1 + 1, idx2 + 1);
        }
        else {
            int d1 = 1 + distance(word1, word2, idx1 + 1, idx2);    //删除word1[idx1]
            int d2 = 1 + distance(word1, word2, idx1, idx2 + 1);    //word1插入一个字符word2[idx2]
            int d3 = 1 + distance(word1, word2, idx1 + 1, idx2 + 1);//word1[idx1]替换为word2[idx2]
            result = Math.min(Math.min(d1, d2), d3);
        }
        record[idx1][idx2] = result;
        return result;
    }

    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        record = new int[len1][len2];

        return distance(word1, word2, 0, 0);
    }
}
