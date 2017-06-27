class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in range(9):
            mark = [0] * 9;
            for j in range(9):
                if board[i][j] != '.':                  #先对每一行作判断
                    mark[(int)(board[i][j])-1] += 1;
                    if mark[(int)(board[i][j])-1] == 2:
                        return False;
            
            markCol = [0] * 9;
            for j in range(9):
                if board[j][i] != '.':                  #再对每一列作判断
                    markCol[(int)(board[j][i])-1] += 1;
                    if markCol[(int)(board[j][i])-1] == 2:
                        return False;
        
        for i in range(3):                              #对每一个方格作判断
            for j in range(3):
                mark = [0] * 9;
                for k in range(3):
                    for m in range(3):
                        if board[i*3 + k][j*3 + m] != '.':
                            mark[(int)(board[i*3 + k][j*3 + m])-1] += 1;
                            if mark[(int)(board[i*3 + k][j*3 + m])-1] == 2:
                                return False;
        return True;