# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        if head.val == val:
            return head.next
        prev = head
        node = head.next
        while node is not None and node.val != val:
            node = node.next
            prev = prev.next
        if node is not None:
            prev.next = node.next
        return head
