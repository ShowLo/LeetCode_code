class Solution {
    private int digitSum(int n) {
        return n / 10 + n % 10;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int count = 1;
        for (int i = 1; i < m; ++i) {
            if (digitSum(i) <= k) {
                visited[i][0] = true;
                ++count;
            }
            else {
                break;
            }
        }
        for (int j = 1; j < n; ++j) {
            if (digitSum(j) <= k) {
                visited[0][j] = true;
                ++count;
            }
            else {
                break;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if ((visited[i - 1][j] || visited[i][j - 1]) && digitSum(i) + digitSum(j) <= k) {
                    visited[i][j] = true;
                    ++count;
                }
            }
        }
        return count;
    }
}
