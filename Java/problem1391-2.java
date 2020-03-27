class Solution {
    // 表示各个方向的x, y坐标变化值
    private final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //TOP - 0, RIGHT - 1, BOTTOM - 2, LEFT - 3
    private final int[][] STREETS = {{-1, -1}, {1, 3}, {0, 2}, {2, 3}, {1, 2}, {0, 3}, {0, 1}};
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return true;
        }
        //从0,0处出发
        for (int direction : STREETS[grid[0][0]]) {
            if (direction == 1 || direction == 2) {
                boolean[][] visited = new boolean[m][n];
                int i = 0, j = 0;
                int currentDir = direction;
                while (true) {
                    //避免有环的存在造成死循环
                    if (visited[i][j]) {
                        break;
                    }
                    visited[i][j] = true;
                    //下一个单元格的位置
                    i += DIRECTIONS[currentDir][0];
                    j += DIRECTIONS[currentDir][1];
                    if (i < 0 || j < 0 || i >= m || j >= n) {
                        break;
                    }
                    int nextGrid = grid[i][j];
                    int nextDir1 = STREETS[nextGrid][0], nextDir2 = STREETS[nextGrid][1];
                    //下一个单元格的某一个方向能与当前单元格向外延展方向匹配，那么下一个向外延展方向就是另一个方向
                    if ((nextDir1 + 2) % 4 == currentDir) {
                        currentDir = nextDir2;
                    }
                    else if ((nextDir2 + 2) % 4 == currentDir) {
                        currentDir = nextDir1;
                    }
                    else {
                        break;
                    }
                    if (i == m - 1 && j == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
