class Solution {
    private int digitSum(int n) {
        return n / 10 + n % 10;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while(!queue.isEmpty()) {
            int[] cord = queue.poll();
            for (int i = 0; i < 2; ++i) {
                int x = cord[0] + dx[i];
                int y = cord[1] + dy[i];
                if (x < m && y < n && !visited[x][y] && digitSum(x) + digitSum(y) <= k) {
                    ++count;
                    visited[x][y] = true;
                    queue.offer(new int[] {x, y});
                }
            }
        }
        return count;
    }
}
