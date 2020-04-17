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
    private Map<Integer, Integer> map;
    private int[] pre;

    private TreeNode build(int pre_i, int in_i, int in_j) {
        if (in_i > in_j) {
            return null;
        }
        TreeNode middleNode = new TreeNode(pre[pre_i]);
        int middleIdx = map.get(pre[pre_i]);
        middleNode.left = build(pre_i + 1, in_i, middleIdx - 1);
        middleNode.right = build(pre_i + middleIdx - in_i + 1, middleIdx + 1, in_j);
        return middleNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return build(0, 0, inorder.length - 1);
    }
}
