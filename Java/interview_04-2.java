class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                // 在当前列，行索引比i小的那些都比target小，上一列中行索引比i小的更是小于target
                // 所以直接移动到上一列，行保持不动
                --j;
            }
            else {
                ++i;
            }
        }
        return false;
    }
}
