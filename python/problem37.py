public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return;
        // 从头开始遍历
        ergodic(board, 0, 0);
    }
    
    private boolean isValid(char[][] board, int i, int j){
        int item = board[i][j];
        for(int k = 0; k < 9; ++k){
            // 判断插入元素之后行列方向是否合法
            if((board[i][k] == item && k != j) || (board[k][j] == item && k != i)){
                return false;
            }
        }
        int row = ((int)i/3) * 3;
        int col = ((int)j/3) * 3;
        // 判断插入元素之后九宫格是否合法
        for(int m = row; m < row + 3; ++m){
            for(int n = col; n < col + 3; ++n){
                if(board[m][n] == item && m != i && n != j){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean ergodic(char[][] board, int i, int j){
        if(j >= 9){
            // 到达最后一列之后转到下一行
            return ergodic(board, i + 1, 0);
        }
        if(i >= 9){
            // 最后一行也遍历完了，成功
            return true;
        }
        // 对于当前元素未填写的情况
        if(board[i][j] == '.'){
            // 试填1到9
            for(int k = 1; k <= 9; ++k){
                board[i][j] = (char) ('0' + k);
                // 插入合法的话
                if(isValid(board, i, j)){
                    // 遍历之后的元素也合法的话就成功了
                    if(ergodic(board, i, j + 1))
                        return true;
                }
                //  还没成功的话需要恢复当前元素为未填写状态
                board[i][j] = '.';
            }
        }
        // 对于当前元素已填写的情况，直接判断下一个
        else{
            return ergodic(board, i, j + 1);
        }
        return false;
    }
}