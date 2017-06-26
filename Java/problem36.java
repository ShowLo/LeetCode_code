public class Solution 
{
    public boolean isValidSudoku(char[][] board)
    {
        for(int i = 0; i < 9; ++i)
        {
            int[] mark = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j = 0; j < 9; ++j)
            {
                if(board[i][j] != '.')                  //先对每一行作判断
                    if(++mark[(int)(board[i][j]) - 49] == 2)
                        return false;
            }
            int[] markCol = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            for(int j = 0; j < 9; ++j)
            {
                if(board[j][i] != '.')                  //再对每一列作判断
                    if(++markCol[(int)(board[j][i]) - 49] == 2)
                        return false;
            }
        }
        for(int i = 0; i < 3; ++i)                      //对每一个方格作判断
        {
            for(int j = 0; j < 3; ++j)
            {
                int[] mark = {0, 0, 0, 0, 0, 0, 0, 0, 0};
                for(int k = 0; k < 3; ++k)
                {
                    for(int m = 0; m < 3; ++m)
                    {
                        if(board[i*3 + k][j*3 + m] != '.')
                            if(++mark[(int)(board[i*3 + k][j*3 + m]) - 49] == 2)
                                return false;
                    }
                }
            }
        }
        return true;
    }
}