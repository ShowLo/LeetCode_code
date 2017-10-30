# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None:
            return None
        num = 1
        node = head
        while node.next is not None:        #先计算有多少节点
            node = node.next
            num += 1
        k = k % num                         #注意取模
        if head.next == None or k == 0:
            return head
        count = 0
        laterNode = head
        for i in range(k):
            laterNode = laterNode.next
        prevNode = head                     #laterNode和prevNode相隔k的距离
        while laterNode.next is not None:
            laterNode = laterNode.next
            prevNode = prevNode.next
        result = prevNode.next
        prevNode.next = None
        node.next = head
        return result