/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prev = head;
        for (int i = 0; i < k; ++i) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            prev = prev.next;
        }
        return prev;
    }
}
