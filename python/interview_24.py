# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        prev = head
        latter = head.next
        head.next = None
        while latter is not None:
            tmp = latter.next
            latter.next = prev
            prev = latter
            latter = tmp
        return prev
