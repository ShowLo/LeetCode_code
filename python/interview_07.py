# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        num2idx = {}
        L = len(inorder)
        for i in range(L):
            num2idx[inorder[i]] = i
        
        def build(pre_i, in_i, in_j):
            if in_i > in_j:
                return None
            middleNode = TreeNode(preorder[pre_i])
            middleIdx = num2idx[preorder[pre_i]]
            middleNode.left = build(pre_i + 1, in_i, middleIdx - 1)
            middleNode.right = build(pre_i + middleIdx - in_i + 1, middleIdx + 1, in_j)
            return middleNode

        return build(0, 0, L - 1)
