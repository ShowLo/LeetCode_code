/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode latter = head.next;
        head.next = null;
        while (latter != null) {
            ListNode tmp = latter.next;
            latter.next = prev;
            prev = latter;
            latter = tmp;
        }
        return prev;
    }
}
