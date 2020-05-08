class Solution:
    def kthSmallest(self, mat: List[List[int]], k: int) -> int:
        self.m = len(mat)
        self.n = len(mat[0])
        self.count = 0
        self.k = k

        def dfs(row, curSum, mid):
            if row == self.m or curSum > mid or self.count >= self.k:
                return
            dfs(row + 1, curSum, mid)
            for j in range(1, self.n):
                if curSum + mat[row][j] - mat[row][0] <= mid:
                    self.count += 1
                    dfs(row + 1, curSum + mat[row][j] - mat[row][0], mid)
                else:
                    break

        left = sum(mat[i][0] for i in range(self.m))
        right = sum(mat[i][-1] for i in range(self.m))
        minSum = left
        while left < right:
            mid = (left + right) // 2
            self.count = 1
            dfs(0, minSum, mid)
            if self.count < k:
                left = mid + 1
            else:
                right = mid
        return right
