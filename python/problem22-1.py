class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        chars = [')' for _ in range(n * 2)]
        result = []
        def dfs(idx, leftNum, rightNum):
            if idx == n * 2:
                result.append(''.join(chars))
                return
            if leftNum < n:
                chars[idx] = '('
                dfs(idx + 1, leftNum + 1, rightNum)
            if rightNum < leftNum:
                chars[idx] = ')'
                dfs(idx + 1, leftNum, rightNum + 1)
        
        dfs(0, 0, 0)
        return result
