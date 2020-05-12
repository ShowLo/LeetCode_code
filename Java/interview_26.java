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
    private boolean isSame(TreeNode A, TreeNode B) {
        if (A == null) {
            return B == null;
        }
        else if (B == null) {
            return true;
        }
        if (A.val == B.val) {
            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }
        else {
            return false;
        }
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val && isSame(A.left, B.left) && isSame(A.right, B.right)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
}
