# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return None;
        if head.next == None:           #只有一个节点的情况
            return head;
        node = head;
        result = head.next;             #交换之后链表的头节点
        while node and node.next:       #还存在下一对节点
            temp = node.next;           #作节点交换处理
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
            if temp and temp.next:      #如果下对节点有两个的话，当前这对节点第二个节点指向下对节点的第二个节点
                node.next = temp.next;
            node = temp;
        return result;