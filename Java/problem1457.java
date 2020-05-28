/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] numCount;
    private int result;
    
    private void dfs(TreeNode node, int oddCount) {
        if (node == null) {
            if (oddCount <= 1) {
                ++result;
            }
            return;
        }
        // 奇数情况+1
        oddCount += (++numCount[node.val - 1] & 1) * 2 - 1;
        if (node.left == null && node.right == null) {
            dfs(node.left, oddCount);
        }
        if (node.left != null) {
            dfs(node.left, oddCount);
        }
        if (node.right != null) {
            dfs(node.right, oddCount);
        }
        // 奇数情况下，回溯时-1
        oddCount += 1 - (numCount[node.val - 1] & 1) * 2;
        --numCount[node.val - 1];
        
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        numCount = new int[9];
        result = 0;
        dfs(root, 0);
        return result;
    }
}
