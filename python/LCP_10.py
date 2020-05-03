# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minimalExecTime(self, root: TreeNode) -> float:
        def dfs(node):
            if node is None:
                return 0, 0
            leftMinTime, leftTotalTime = dfs(node.left)
            rightMinTime, rightTotalTime = dfs(node.right)
            return node.val + max(leftMinTime, rightMinTime, (leftTotalTime + rightTotalTime) / 2), node.val + leftTotalTime + rightTotalTime
        
        return dfs(root)[0]
