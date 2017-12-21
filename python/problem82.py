# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head
        isDuplicate = False
        while head.next is not None:            #先把前面所有重复的去掉，找到第一个不重复的作为头节点
            if head.next.val == head.val:
                head = head.next
                isDuplicate = True
            elif isDuplicate:
                head = head.next
                isDuplicate = False
            else:
                break
        if head.next is None and isDuplicate:   #全都是重复的，只能返回空了
            return None
        node = head
        prev = head
        isDuplicate = False
        while node.next is not None:            #再去掉头节点后面所有重复的节点
            if node.next.val == node.val:
                prev.next = node.next
                isDuplicate = True
            elif isDuplicate:
                prev.next = node.next
                isDuplicate = False
            else:
                prev = node
            node = node.next
        if isDuplicate:                         #最后面的数是重复的
            prev.next = None
        return head