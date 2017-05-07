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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int sum = l1.val + l2.val;                  //模仿加法过程，首先最低位数字相加
        ListNode l3 = new ListNode(sum % 10);       //取出其和个位上的数字加入结果链表中的最低位
        ListNode result = l3;                       //记录链表头结点位置
        int r = sum / 10;                           //记录进位
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null)             //遍历两个链表
        {
            sum = l1.val + l2.val + r;              //这里除了加上两个加数对应数位上的数还要加上进位
            l3.next = new ListNode(sum % 10);
            r = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }
        if(l1 != null)                              //如果l1链表还有数位未遍历到，继续遍历
        {
            while(l1 != null)
            {
                sum = l1.val + r;                   //这里只需要加上l1链表对应数位上的数字以及进位
                l3.next = new ListNode(sum % 10);
                r = sum / 10;
                l1 = l1.next;
                l3 = l3.next;
            }
        }
        else if(l2 != null)                         //如果l2链表还有数位未遍历到，继续遍历
        {
            while(l2 != null)
            {
                sum = l2.val + r;                   //这里只需要加上l2链表对应数位上的数字以及进位
                l3.next = new ListNode(sum % 10);
                r = sum / 10;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if(r != 0)                                  //最后，如果还有进位产生，要将其加到结果链表的最后去
            l3.next = new ListNode(r);
        return result;
    }
}