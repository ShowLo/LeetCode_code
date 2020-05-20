# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        import queue
        q = queue.Queue()
        q.put(root)
        result = []
        while not q.empty():
            node = q.get()
            result.append(node.val)
            if node.left is not None:
                q.put(node.left)
            if node.right is not None:
                q.put(node.right)
        return result
