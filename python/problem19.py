# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        stack = [];
        node = head;
        while node:
            stack.append(node);     #节点非空的话入栈
            node = node.next;       #节点后移
        for i in range(n - 1):
            stack.pop();
        out = stack.pop();          #这是需要移除的节点
        if out == head:             #如果要移除的是头节点
            head = out.next;        #那直接将原先头节点的后继节点作为新的头节点
        else:                       #如果要移除的不是头节点
            prev = stack.pop();     #先将要移除节点的前面一个节点出栈
            prev.next = out.next;   #删掉所要移除的节点
        return head;