# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        sum = l1.val + l2.val;
        l3 = ListNode(sum % 10);
        result = l3;
        r = sum // 10;
        l1 = l1.next;
        l2 = l2.next;
        while l1 and l2:
            sum = l1.val + l2.val + r;
            l3.next = ListNode(sum % 10);
            r = sum // 10;
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        if l1:
            while l1:
                sum = l1.val + r;
                l3.next = ListNode(sum % 10);
                r = sum // 10;
                l1 = l1.next;
                l3 = l3.next;
        elif l2:
            while l2:
                sum = l2.val + r;
                l3.next = ListNode(sum % 10);
                r = sum // 10;
                l2 = l2.next;
                l3 = l3.next;
        if r:
            l3.next = ListNode(r);
        return result;