# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        queue = collections.deque()
        queue.append(root)
        result = []
        while len(queue) > 0:
            size = len(queue)
            item = []
            for i in range(size):
                node = queue.popleft()
                item.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            result.append(item)
        return result
