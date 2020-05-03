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
    private double[] dfs(TreeNode node) {
        if (node == null) {
            return new double[] {0, 0};
        }
        double[] leftTime = dfs(node.left);
        double[] rightTime = dfs(node.right);
        double minTime = node.val + Math.max(Math.max(leftTime[0], rightTime[0]), (leftTime[1] + rightTime[1]) / 2.0);
        double maxTime = node.val + leftTime[1] +rightTime[1];
        return new double[] {minTime, maxTime};
    }
    public double minimalExecTime(TreeNode root) {
        double[] result = dfs(root);
        return result[0];
    }
}
