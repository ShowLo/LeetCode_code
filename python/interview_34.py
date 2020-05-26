# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if root is None:
            return []
        result = []
        item = []
        def dfs(node, target):
            if node.left is None and node.right is None:
                if node.val == target:
                    item.append(node.val)
                    result.append(item[:])
                    item.pop()
                return
            item.append(node.val)
            if node.left is not None:
                dfs(node.left, target - node.val)
            if node.right is not None:
                dfs(node.right, target - node.val)
            item.pop()
        dfs(root, sum)
        return result
