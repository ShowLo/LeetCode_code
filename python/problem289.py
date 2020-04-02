class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        one2zero = 2
        zero2one = -1
        row = len(board)
        col = len(board[0])

        def count(i, j):
            num = 0
            for m in range(max(0, i - 1), min(i + 2, row)):
                for n in range(max(0, j - 1), min(j + 2, col)):
                    if board[m][n] >= 1:
                        num += 1
            return num - board[i][j]

        for i in range(row):
            for j in range(col):
                onesNum = count(i, j)
                if board[i][j] == 0 and onesNum == 3:
                    board[i][j] = zero2one
                elif board[i][j] == 1 and (onesNum < 2 or onesNum >3):
                    board[i][j] = one2zero
        for i in range(row):
            for j in range(col):
                if board[i][j] == one2zero:
                    board[i][j] = 0
                elif board[i][j] == zero2one:
                    board[i][j] = 1
