/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        int length = 0;
        ListNode node = head;
        while(node != null)                     //先求出链表长度
        {
            ++length;
            node = node.next;
        }
        int loop = length / k;                  //需要反转的分段个数
        if(loop == 0 || k == 1)
            return head;
        node = head;
        ListNode prev = node, nextNode = node.next, temp;
        for(int j = 0; j < k - 1; ++j)          //先完成第一个分段的反转
        {
            temp = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = temp;
        }
        ListNode result = node, prevtemp;
        for(int i = 0; i < loop - 1; ++i)       //再完成余下分段的反转
        {
            node = nextNode;
            nextNode = node.next;
            prevtemp = node;
            for(int j = 0; j < k - 1; ++j)      //对每个分段里的k个节点进行反转
            {
                temp = nextNode.next;
                nextNode.next = node;
                node = nextNode;
                nextNode = temp;
            }
            prev.next = node;
            prev = prevtemp;
        }
        prev.next = nextNode;                   //最后将上个分段反转后的最后一个节点连到最后一个非分段的第一个节点
        return result;
    }
}