class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    private boolean visitTarget(int[][] grid, int i, int j, int inGrid, int direction) {
        //direction: 0->right, 1 -< left, 2 | bottom, 3 ^ upper
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (inGrid == 0) {
            if (grid[0][0] == 1) {
                return visitTarget(grid, 0, 1, grid[0][0], 0);
            }
            else if (grid[0][0] == 2 || grid[0][0] == 3) {
                return visitTarget(grid, 1, 0, grid[0][0], 2);
            }
            else if (grid[0][0] == 4) {
                return visitTarget(grid, 1, 0, grid[0][0], 2) || visitTarget(grid, 0, 1, grid[0][0], 0);
            }
            else if (grid[0][0] == 5) {
                return false;
            }
            else {
                return visitTarget(grid, 0, 1, grid[0][0], 0);
            }
        }
        
        if (grid[i][j] == 1) {
            if (direction == 0) {
                if (inGrid == 2 || inGrid == 3 || inGrid == 5)
                    return false;
            }
            else if (direction == 1) {
                if (inGrid == 2 || inGrid == 4 || inGrid == 6) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else if (grid[i][j] == 2) {
            if (direction == 2) {
                if (inGrid == 1 || inGrid == 5 || inGrid == 6)
                    return false;
            }
            else if (direction == 3) {
                if (inGrid == 51 || inGrid == 3 || inGrid == 4) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else if (grid[i][j] == 3) {
            if (direction == 0) {
                if (inGrid == 2 || inGrid == 3 || inGrid == 5)
                    return false;
            }
            else if (direction == 3) {
                if (inGrid == 1 || inGrid == 3 || inGrid == 4) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else if (grid[i][j] == 4) {
            if (direction == 1) {
                if (inGrid == 2 || inGrid == 4 || inGrid == 6)
                    return false;
            }
            else if (direction == 3) {
                if (inGrid == 1 || inGrid == 3 || inGrid == 4) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else if (grid[i][j] == 5) {
            if (direction == 0) {
                if (inGrid == 2 || inGrid == 3 || inGrid == 5)
                    return false;
            }
            else if (direction == 2) {
                if (inGrid == 1 || inGrid == 5 || inGrid == 6) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            if (direction == 1) {
                if (inGrid == 2 || inGrid == 4 || inGrid == 6)
                    return false;
            }
            else if (direction == 2) {
                if (inGrid == 1 || inGrid == 5 || inGrid == 6) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        
        if (grid[i][j] == 1) {
            return visitTarget(grid, i, j - 1, grid[i][j], 1) || visitTarget(grid, i, j + 1, grid[i][j], 0);
        }
        else if (grid[i][j] == 2) {
            return visitTarget(grid, i - 1, j, grid[i][j], 3) || visitTarget(grid, i + 1, j, grid[i][j], 2);
        }
        else if (grid[i][j] == 3) {
            return visitTarget(grid, i + 1, j, grid[i][j], 2) || visitTarget(grid, i, j - 1, grid[i][j], 1);
        }
        else if (grid[i][j] == 4) {
            return visitTarget(grid, i + 1, j, grid[i][j], 2) || visitTarget(grid, i, j + 1, grid[i][j], 0);
        }
        else if (grid[i][j] == 5) {
            return visitTarget(grid, i - 1, j, grid[i][j], 3) || visitTarget(grid, i, j - 1, grid[i][j], 1);
        }
        else {
            return visitTarget(grid, i - 1, j, grid[i][j], 3) || visitTarget(grid, i, j + 1, grid[i][j], 0);
        }
    }
    
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 1 && n == 1) {
            return true;
        }
        visited = new boolean[m][n];
        return visitTarget(grid, 0, 0, 0, 0);
    }
}
