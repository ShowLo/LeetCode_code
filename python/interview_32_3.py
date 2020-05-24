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
        result = []
        deque = collections.deque()
        deque.append(root)
        level = 0
        while len(deque) > 0:
            size = len(deque)
            item = []
            for _ in range(size):
                node = deque.popleft()
                item.append(node.val)
                if node.left is not None:
                    deque.append(node.left)
                if node.right is not None:
                    deque.append(node.right)
            if level % 2 == 1:
                result.append(item[::-1])
            else:
                result.append(item)
            level += 1
        return result
