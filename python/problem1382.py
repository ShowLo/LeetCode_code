# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        sortedLst = []
        def inorderTraversal(node):         #中序遍历，得到一个排好序的节点值列表
            if node is None:
                return
            inorderTraversal(node.left)
            sortedLst.append(node.val)
            inorderTraversal(node.right)

        def bulidTree(left, right):         #以列表中间节点为根节点，左边节点为左子树，右边节点为右子树
            if left > right:
                return None
            if left == right:
                return TreeNode(sortedLst[left])
            middldIdx = left + (right - left) // 2
            node = TreeNode(sortedLst[middldIdx])
            node.left = bulidTree(left, middldIdx - 1)
            node.right = bulidTree(middldIdx + 1, right)
            return node
        
        inorderTraversal(root)
        return bulidTree(0, len(sortedLst) - 1)
