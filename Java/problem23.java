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
    public ListNode mergeKLists(ListNode[] lists)
    {
        int length = lists.length;
        if(length == 0)
            return null;
        if(length == 1)
            return lists[0];
        if(length == 2)
            return mergeTwoLists(lists[0],lists[1]);
        int lenToMerge = length;
        int mid = (length - 1) / 2;
        ListNode[] before = new ListNode[mid];
        ListNode[] after = new ListNode[length - mid];
        System.arraycopy(lists, 0, before, 0, mid);
        System.arraycopy(lists, mid, after, 0, length - mid);
        ListNode left = mergeKLists(before);//先对前半部分进行排序
        ListNode right = mergeKLists(after);//再对后半部分进行排序
        return mergeTwoLists(left,right);   //最后再对前两部分的排序结果进行最后一次排序
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode result = l1;
        if(l1 == null)                      //链表1为空的话直接返回链表2
            return l2;
        if(l2 == null)                      //链表2为空的话直接返回链表1
            return l1;
        if(l1.val < l2.val)                 //结果链表的头节点为两链表头节点中值较小的那个
        {
            result = l1;
            l1 = l1.next;
        }
        else
        {
            result = l2;
            l2 = l2.next;
        }
        ListNode node = result;
        
        while(l1 != null && l2 != null)     //在l1和l2均不遍历完的情况下
        {
            if(l1.val < l2.val)             //l1对应的值较小
            {
                node.next = l1;             //加入到整合链表
                node = node.next;
                l1 = l1.next;               //后移
            }
            else                            //l2对应的值较小
            {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)                      //l1未遍历完的话再将其加入整合链表
            node.next = l1;
        if(l2 != null)                      //l2未遍历完的话再将其加入整合链表
            node.next = l2;
            
        return result;
    }
}