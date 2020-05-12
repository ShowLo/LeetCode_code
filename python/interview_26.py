# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        def isSame(nodeA, nodeB):
            if nodeA is None:
                return nodeB is None
            if nodeB is None:
                return True
            if nodeA.val == nodeB.val and isSame(nodeA.left, nodeB.left) and isSame(nodeA.right, nodeB.right):
                return True
            return False
        if A is None or B is None:
            return False
        if A.val == B.val and isSame(A.left, B.left) and isSame(A.right, B.right):
            return True
        return self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)
