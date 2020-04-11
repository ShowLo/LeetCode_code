class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        char2num = {'a' : a,  'b' : b, 'c' : c}

        def nextChar(exclude):
            if exclude == 'a':
                return 'b' if char2num['b'] > char2num['c'] else 'c'
            elif exclude == 'b':
                return 'a' if char2num['a'] > char2num['c'] else 'c'
            elif exclude == 'c':
                return 'a' if char2num['a'] > char2num['b'] else 'b'
            else:
                nc = 'a' if char2num['a'] > char2num['b'] else 'b'
                return nc if char2num[nc] > char2num['c'] else 'c'
        
        result = ''
        while char2num['a'] > 0 or char2num['b'] > 0 or char2num['c'] > 0:
            L = len(result)
            nc = 'a'
            if L < 2 or result[L - 1] != result[L - 2]:
                nc = nextChar(' ')
            else:
                nc = nextChar(result[L - 1])
            if char2num[nc] <= 0:
                break
            char2num[nc] -= 1
            result += nc
        return result
