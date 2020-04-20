class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] P = new int[m];
        for (int i = 0; i < m; ++i) {
            P[i] = i + 1;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int idx = 0;
            while (idx < m) {
                if (P[idx] == queries[i]) {
                    break;
                }
                else {
                    ++idx;
                }
            }
            result[i] = idx;
            int temp = P[idx];
            for (int j = idx; j >= 1; --j) {
                P[j] = P[j - 1];
            }
            P[0] = temp;
        }
        return result;
    }
}
