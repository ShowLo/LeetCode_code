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
    List<List<Integer>> result;
    LinkedList<Integer> item;

    private void visit(TreeNode node, int target) {
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                item.add(node.val);
                result.add(new LinkedList<Integer>(item));
                item.removeLast();
            }
            return;
        }
        item.add(node.val);
        if (node.left != null) {
            visit(node.left, target - node.val);
        }
        if (node.right != null) {
            visit(node.right, target - node.val);
        }
        item.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        item = new LinkedList<>();
        visit(root, sum);
        return result;
    }
}
