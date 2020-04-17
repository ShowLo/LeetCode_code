/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int count = 0;
        ListNode prev = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            head = next;
            next = head.next;
            head.next = prev;
            prev = head;
            ++count;
        }
        int[] result = new int[count + 1];
        int i = 0;
        while (head != null) {
            result[i++] = head.val;
            head = head.next;
        }
        return result;
    }
}
