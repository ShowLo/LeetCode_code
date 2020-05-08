class Solution {
    private int m;
    private int n;
    private int count;

    private void dfs(int[][] mat, int row, int k, int sum, int mid) {
        if (row == m || count >= k || sum > mid) {
            // 及时剪枝
            return;
        }
        // 进入下一行，当前行取第0位，注意不要放到下面的循环里去，不然会重复计算
        dfs(mat, row + 1, k, sum, mid);
        for (int j = 1; j < n; ++j) {
            if (sum + mat[row][j] - mat[row][0] <= mid) {
                // 只要不超过mid的都可以进入下一行继续搜索，当前行取第i位，下面所有行都还是第0位
                ++count;
                dfs(mat, row + 1, k, sum + mat[row][j] - mat[row][0], mid);
            }
            else {
                break;
            }
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;
        int left = 0, right = 0;
        for (int i = 0; i < m; ++i) {
            left += mat[i][0];
            right += mat[i][n - 1];
        }
        int minSum = left;
        // 二分搜索，最后结束时有left==right，且count==k
        while (left < right) {
            int middle = left + (right - left) / 2;
            count = 1;
            dfs(mat, 0, k, minSum, middle);
            if (count < k) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        return right;
    }
}
