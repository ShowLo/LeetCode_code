# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        length = 0;
        node = head;
        while node:                             #先求出链表长度
            length += 1;
            node = node.next;
        loop = length // k;                     #需要反转的分段个数
        if loop == 0 or k == 1:
            return head;
        node = head;
        prev = node;
        nextNode = node.next;
        for j in range(k - 1):                  #先完成第一个分段的反转
            temp = nextNode.next;
            nextNode.next = node;
            node,nextNode = nextNode,temp;
        result = node;
        for i in range(loop - 1):               #再完成余下分段的反转
            node = nextNode;
            nextNode = node.next;
            prevtemp = node;
            for j in range(k - 1):              #对每个分段里的k个节点进行反转
                temp = nextNode.next;
                nextNode.next = node;
                node,nextNode = nextNode,temp;
            prev.next = node;
            prev = prevtemp;
        prev.next = nextNode;                   #最后将上个分段反转后的最后一个节点连到最后一个非分段的第一个节点
        return result;