class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])
        if row * col < len(word):
            return False
        visited = [[False for _ in range(col)] for _ in range(row)]

        def dfs(i, j, targetIdx):
            if i < 0 or j < 0 or i >= row or j >= col or visited[i][j] or board[i][j] != word[targetIdx]:
                return False
            if targetIdx == len(word) - 1:
                return True
            visited[i][j] = True
            find = dfs(i, j - 1, targetIdx + 1) or dfs(i, j + 1, targetIdx + 1) or dfs(i - 1, j, targetIdx + 1) or dfs(i + 1, j, targetIdx + 1)
            visited[i][j] = False
            return find

        for i in range(row):
            for j in range(col):
                if dfs(i, j, 0):
                    return True
        return False
