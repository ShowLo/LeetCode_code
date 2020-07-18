class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        if (left.length == 0 && right.length == 0) {
            return 0;
        }
        int leftMax = -1, rightMin = n;
        for (int l : left) {
            leftMax = Math.max(leftMax, l);
        }
        for (int r : right) {
            rightMin = Math.min(rightMin, r);
        }
        if (left.length == 0) {
            return n - rightMin;
        }
        if (right.length == 0) {
            return leftMax;
        }
        return Math.max(leftMax, n - rightMin);
    }
}
