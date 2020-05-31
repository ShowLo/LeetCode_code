/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head;
    private Node preNode;

    private void inorderVisit(Node node) {
        if (node == null) {
            return;
        }
        inorderVisit(node.left);
        if (preNode == null) {
            head = node;
        }
        else {
            preNode.right = node;
            node.left = preNode;
        }
        preNode = node;
        inorderVisit(node.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorderVisit(root);
        head.left = preNode;
        preNode.right = head;
        return head;
    }
}
