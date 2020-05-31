"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        if not root:
            return None
        self.preNode = None
        self.head = None

        def inorderVisit(node):
            if not node:
                return
            inorderVisit(node.left)
            if self.preNode:
                self.preNode.right = node
                node.left = self.preNode
            else:
                self.head = node
            self.preNode = node
            inorderVisit(node.right)

        inorderVisit(root)
        self.preNode.right = self.head
        self.head.left = self.preNode
        return self.head
