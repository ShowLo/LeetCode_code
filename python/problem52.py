class Solution(object):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = [0]
        self.recursion(n, 0, [], result)
        return result[0]
        
    def recursion(self, n, row, board, result):
        for i in range(n):
            #对当前行，依次判断各个位置上可否放置皇后
            if not self.existQ(row, i, board, n):
                board_copy = [k for k in board]
                board_copy.append('.' * i + 'Q' + '.' * (n - 1 - i))
                if row == n - 1:
                    result[0] += 1
                else:
                    self.recursion(n, row + 1, board_copy, result)
    
    #判断是否存在冲突
    def existQ(self, row, col, board, n):
        for i in range(row):        #先判断此列上有没有冲突
            if board[i][col] == 'Q':
                return True
        r, c = row, col
        while r > 0 and c > 0:      #再判断左对角线上有没有冲突
            r -= 1
            c -= 1
            if board[r][c] == 'Q':
                return True
        r, c = row, col
        while r > 0 and c < n - 1:  #最后判断右对角线上有没有冲突
            r -= 1
            c += 1
            if board[r][c] == 'Q':
                return True
        return False