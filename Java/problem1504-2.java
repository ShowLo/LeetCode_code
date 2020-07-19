class Solution {
    public int numSubmat(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 0) {
                    continue;
                }
                mat[i][j] = mat[i - 1][j] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < row; ++i) {
            Stack<int[]> stack = new Stack<>();
            int cursum = 0;
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 0) {
                    stack = new Stack<>();
                    cursum = 0;
                    continue;
                }
                if (stack.empty() || mat[i][j] > stack.peek()[0]) {
                    stack.push(new int[] {mat[i][j], 1});
                    cursum += mat[i][j];
                    result += cursum;
                }
                else {
                    int curWidth = 1;
                    while (!stack.empty() && stack.peek()[0] >= mat[i][j]) {
                        int[] hw = stack.pop();
                        curWidth += hw[1];
                        cursum -= (hw[0] - mat[i][j]) * hw[1];
                    }
                    stack.push(new int[] {mat[i][j], curWidth});
                    cursum += mat[i][j];
                    result += cursum;
                }
            }
        }
        return result;
    }
}
