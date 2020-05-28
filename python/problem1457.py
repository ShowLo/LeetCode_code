# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: TreeNode) -> int:
        self.result = 0
        count = [0] * 10
        def dfs(node, oddCount):
            if not node:
                if oddCount <= 1:
                    self.result += 1
                return
            count[node.val] += 1
            oddCount += 1 if (count[node.val] & 1) == 1 else -1
            if not node.left and not node.right:
                dfs(node.left, oddCount)
            if node.left:
                dfs(node.left, oddCount)
            if node.right:
                dfs(node.right, oddCount)
            oddCount -= 1 if (count[node.val] & 1) == 1 else -1
            count[node.val] -= 1
        dfs(root, 0)
        return self.result
