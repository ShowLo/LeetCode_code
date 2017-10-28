class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        left = top = 0
        bottom = n - 1
        if bottom == -1:
            return []
        right = n - 1
        if right == -1:
            return []
        result = [[0] * n for i in range(n)]
        num = 1
        while left <= right and top <= bottom:
            for i in range(left, right + 1):
                result[top][i] = num
                num += 1
            top += 1
            
            for i in range(top, bottom + 1):
                result[i][right] = num
                num += 1
            right -= 1
            
            if top <= bottom:
                for i in range(right, left - 1, -1):
                    result[bottom][i] = num
                    num += 1
                bottom -= 1
            
            if left <= right:
                for i in range(bottom, top -1, -1):
                    result[i][left] = num
                    num += 1
                left += 1
        return result