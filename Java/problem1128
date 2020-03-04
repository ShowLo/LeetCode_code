class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0, key;
        int[] record = new int[100];
        for (int[] pair : dominoes) {
            if (pair[0] < pair[1]) {
                key = pair[0] * 10 + pair[1];
            }
            else {
                key = pair[1] * 10 + pair[0];
            }
            count += record[key]++;
        }
        return count;
    }
}
