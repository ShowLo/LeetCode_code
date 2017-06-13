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
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null)
            return null;
        if(head.next == null)                       //只有一个节点的情况
            return head;
        ListNode node = head, temp;
        ListNode result = head.next;                //交换之后链表的头节点
        while(node != null && node.next != null)    //还存在下一对节点
        {
            temp = node.next;                       //作节点交换处理
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
            if(temp != null && temp.next != null)   //如果下对节点有两个的话，当前这对节点第二个节点指向下对节点的第二个节点
                node.next = temp.next;
            node = temp;
        }
        return result;
    }
}