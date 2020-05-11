# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        prev = head
        for i in range(k):
            head = head.next
        while head is not None:
            head = head.next
            prev = prev.next
        return prev
