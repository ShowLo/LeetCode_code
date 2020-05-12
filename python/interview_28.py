# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        def symmetric(left, right):
            if left is None or right is None:
                return left is None and right is None
            if left.val != right.val:
                return False
            return symmetric(left.left, right.right) and symmetric(left.right, right.left)
        return symmetric(root.left, root.right)
