"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        ori2copy = {}
        if not head:
            return None
        newHead = Node(head.val)
        ori2copy[head] = newHead
        node = newHead
        while head:
            if head.next and head.next in ori2copy:
                node.next = ori2copy[head.next]
            elif head.next:
                nextNode = Node(head.next.val)
                ori2copy[head.next] = nextNode
                node.next = nextNode
            if head.random and head.random in ori2copy:
                node.random = ori2copy[head.random]
            elif head.random:
                randomNode = Node(head.random.val)
                ori2copy[head.random] = randomNode
                node.random = randomNode
            head = head.next
            node = node.next
        return newHead
