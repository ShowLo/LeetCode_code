class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        row = len(board)
        col = len(board[0])
        visited = [[False] * col for k in range(row)]
        for i in range(row):
            for j in range(col):
                if self.search(board, word, i, j, 0, visited):
                    return True
        return False
        
    def search(self, board, word, i, j, count, visited):
        row = len(board)
        col = len(board[0])
        if i >= row or j >= col or i < 0 or j < 0 or visited[i][j] or board[i][j] != word[count]:
            #越界或者已被访问过了
            return False
        #查找成功
        if count == len(word) - 1:
            return True
        count += 1
        #置访问标志
        visited[i][j] = True
        #向邻接点前进
        result = self.search(board, word, i + 1, j, count, visited) or self.search(board, word, i - 1, j, count, visited) or self.search(board, word, i, j + 1, count, visited) or self.search(board, word, i, j - 1, count, visited)
        #重置为未访问
        visited[i][j] = False
        return result
            