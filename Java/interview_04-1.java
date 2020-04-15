class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int jMin, jMax, jMid;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] > target) {
                return false;
            }
            if (matrix[i][matrix[0].length - 1] < target) {
                continue;
            }
            jMin = 0;
            jMax = matrix[0].length - 1;
            while (jMin <= jMax) {
                jMid = (jMin + jMax) / 2;
                if (matrix[i][jMid] == target) {
                    return true;
                }
                else if (matrix[i][jMid] > target) {
                    jMax = jMid - 1;
                }
                else {
                    jMin = jMid + 1;
                }
            }
        }
        return false;
    }
}
