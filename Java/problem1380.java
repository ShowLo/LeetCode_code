class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] recordMin = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            int minJ = 0;
            for (int j = 1; j < col; ++j) {
                if (matrix[i][j] < matrix[i][minJ]) {
                    minJ = j;
                }
            }
            recordMin[i][minJ] = true;
        }
        List<Integer> result = new LinkedList<>();
        for (int j = 0; j < col; ++j) {
            int maxI = 0;
            for (int i = 1; i < row; ++i) {
                if (matrix[i][j] > matrix[maxI][j]) {
                    maxI = i;
                }
            }
            if (recordMin[maxI][j]) {
                result.add(matrix[maxI][j]);
            }
        }
        return result;
    }
}
