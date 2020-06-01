/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nodeCount = 1;
        StringBuilder sb = new StringBuilder("[");
        while (nodeCount > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            }
            else {
                sb.append(node.val + ",");
                --nodeCount;
                queue.offer(node.left);
                if (node.left != null) {
                    ++nodeCount;
                }
                queue.offer(node.right);
                if (node.right != null) {
                    ++nodeCount;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] strs = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        int idx = 1;
        while (idx < strs.length) {
            TreeNode node = queue.poll();
            if (!strs[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(node.left);
            }
            ++idx;
            if (idx < strs.length && !strs[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(node.right);
            }
            ++idx;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
