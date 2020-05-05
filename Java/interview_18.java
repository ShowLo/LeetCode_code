/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode prev = head;
        ListNode node = head.next;
        while (node != null && node.val != val) {
            node = node.next;
            prev = prev.next;
        }
        if (node != null) {
            prev.next = node.next;
        }
        return head;
    }
}
