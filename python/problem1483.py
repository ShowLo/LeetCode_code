class TreeAncestor:

    def __init__(self, n: int, parent: List[int]):
        bits = math.ceil(math.log(n, 2))
        self.dp = [[0 for _ in range(n)] for _ in range(bits)]
        for j in range(n):
            self.dp[0][j] = parent[j]
        for i in range(1, bits):
            for j in range(n):
                self.dp[i][j] = -1 if self.dp[i - 1][j] == -1 else self.dp[i - 1][self.dp[i - 1][j]]

    def getKthAncestor(self, node: int, k: int) -> int:
        i = 0
        while k > 0:
            if node == -1:
                return -1
            if k % 2 == 1:
                node = self.dp[i][node]
            i += 1
            k >>= 1
        return node      


# Your TreeAncestor object will be instantiated and called as such:
# obj = TreeAncestor(n, parent)
# param_1 = obj.getKthAncestor(node,k)
