# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:              #链表1为空的话直接返回链表2
            return l2;
        if l2 == None:              #链表2为空的话直接返回链表1
            return l1;
        if l1.val < l2.val:         #结果链表的头节点为两链表头节点中值较小的那个
            result = l1;
            l1 = l1.next;
        else:
            result = l2;
            l2 = l2.next;
        node = result;
        
        while l1 and l2:            #在l1和l2均不遍历完的情况下
            if l1.val < l2.val:     #l1对应的值较小
                node.next = l1;     #加入到整合链表
                node = node.next;
                l1 = l1.next;       #后移
            else:                   #l2对应的值较小
                node.next = l2;
                node = node.next;
                l2 = l2.next;
        if l1:                      #l1未遍历完的话再将其加入整合链表
            node.next = l1;
        if l2:                      #l2未遍历完的话再将其加入整合链表
            node.next = l2;
            
        return result;