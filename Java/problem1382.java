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
    private List<Integer> sortedLst;
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        sortedLst.add(node.val);
        inorderTraversal(node.right);
    }
    
    private TreeNode buildTree(int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }
        if (leftIdx == rightIdx) {
            return new TreeNode(sortedLst.get(leftIdx));
        }
        int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;
        TreeNode root = new TreeNode(sortedLst.get(middleIdx));
        root.left = buildTree(leftIdx, middleIdx - 1);
        root.right = buildTree(middleIdx + 1, rightIdx);
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        sortedLst = new ArrayList<>();
        inorderTraversal(root);
        return buildTree(0, sortedLst.size() - 1);
    }
}
