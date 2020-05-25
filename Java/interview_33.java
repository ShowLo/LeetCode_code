class Solution {
    private boolean isValid(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int root = postorder[right];
        int idx;
        for (idx = left; idx < right; ++idx) {
            if (postorder[idx] > root) {
                break;
            }
        }
        for (int i = idx; i < right; ++i) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return isValid(postorder, left, idx - 1) && isValid(postorder, idx, right - 1);
    }
    public boolean verifyPostorder(int[] postorder) {
        return isValid(postorder, 0, postorder.length - 1);
    }
}
