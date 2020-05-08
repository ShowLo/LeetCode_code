class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < m; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                for (int item : list) {
                    temp.add(item + mat[i][j]);
                }
            }
            Collections.sort(temp);
            list = temp.subList(0, Math.min(k, temp.size()));
        }
        return list.get(k - 1);
    }
}
