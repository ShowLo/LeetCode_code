/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    private Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node node = newHead;
        map.put(head, newHead);
        while (head != null) {
            if (head.next == null) {
                node.next = null;
            }
            else if (map.containsKey(head.next)) {
                node.next = map.get(head.next);
            }
            else {
                Node nextNode = new Node(head.next.val);
                node.next = nextNode;
                map.put(head.next, nextNode);
            }
            if (head.random == null) {
                node.random = null;
            }
            else if (map.containsKey(head.random)) {
                node.random = map.get(head.random);
            }
            else {
                Node randomNode = new Node(head.random.val);
                node.random = randomNode;
                map.put(head.random, randomNode);
            }
            head = head.next;
            node = node.next;
        }
        return newHead;
    }
}
