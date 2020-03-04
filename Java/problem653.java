/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode pushLeft(TreeNode leftNode, Stack<TreeNode> leftNodeStack) {
        while (leftNode.left != null) {
            leftNodeStack.push(leftNode);
            leftNode = leftNode.left;
        }
        return leftNode;
    }

    private TreeNode pushRight(TreeNode rightNode, Stack<TreeNode> rightNodeStack) {
        while (rightNode.right != null) {
            rightNodeStack.push(rightNode);
            rightNode = rightNode.right;
        }
        return rightNode;
    }
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> leftNodeStack = new Stack<>();
        Stack<TreeNode> rightNodeStack = new Stack<>();
        TreeNode leftNode = pushLeft(root, leftNodeStack);
        TreeNode rightNode = pushRight(root, rightNodeStack);
        int sum2num = 0;
        while (leftNode != rightNode) {
            sum2num = leftNode.val + rightNode.val;
            if (sum2num == k) {
                return true;
            }
            else if (sum2num <  k) {
                if (leftNode.right != null) {
                    leftNode = pushLeft(leftNode.right, leftNodeStack);
                }
                else {
                    leftNode = leftNodeStack.pop();
                }
            }
            else {
                if (rightNode.left != null) {
                    rightNode = pushRight(rightNode.left, rightNodeStack);
                }
                else {
                    rightNode = rightNodeStack.pop();
                }
            }
        }
        return false;
    }
}
