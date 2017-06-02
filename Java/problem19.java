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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode font = head, tail = head;
        for(int i = 0; i < n; ++i)      //移动使font和tail前后两节点相隔n
            tail = tail.next;
        if(tail == null)                //要移除的是头节点
            return head.next;
        while(tail.next != null)        //后节点移到最后
        {
            tail = tail.next;
            font = font.next;
        }
        font.next = font.next.next;     //删除倒数第n个节点
        return head;
    }
}