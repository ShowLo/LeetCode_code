class Solution:
    def permutation(self, s: str) -> List[str]:
        chars = [ss for ss in s]
        n = len(chars)
        result = []

        def dfs(idx):
            if idx == n - 1:
                result.append(''.join(chars))
                return
            visited = set()
            visited.add(chars[idx])
            dfs(idx + 1)
            for i in range(idx + 1, n):
                if not chars[i] in visited:
                    visited.add(chars[i])
                    chars[idx], chars[i] = chars[i], chars[idx]
                    dfs(idx + 1)
                    chars[idx], chars[i] = chars[i], chars[idx]
        dfs(0)
        return result
