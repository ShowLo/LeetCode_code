class Solution:
    def isNumber(self, s: str) -> bool:
        transfer = [[ 0, 1, 6, 2,-1],
                    [-1,-1, 6, 2,-1],
                    [-1,-1, 3,-1,-1],
                    [ 8,-1, 3,-1, 4],
                    [-1, 7, 5,-1,-1],
                    [ 8,-1, 5,-1,-1],
                    [ 8,-1, 6, 3, 4],
                    [-1,-1, 5,-1,-1],
                    [ 8,-1,-1,-1,-1]]

        def getIdx(c):
            if c == ' ':
                return 0
            if c == '+' or c == '-':
                return 1
            if c >= '0' and c <= '9':
                return 2
            if c == '.':
                return 3
            if c == 'e':
                return 4
            return -1

        state, idx = 0, 0
        for c in s:
            idx = getIdx(c)
            if idx < 0:
                return False
            state = transfer[state][idx]
            if state < 0:
                return False

        return transfer[state][0] == 8
