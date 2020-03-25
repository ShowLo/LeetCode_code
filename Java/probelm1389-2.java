class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int L = index.length;
        int[] result = new int[L];
        boolean[] fill = new boolean[L];
        for (int i = L - 1; i >= 0; --i) {
            int count = -1;
            for (int j = 0; j < L; ++j) {
                if (!fill[j]) {
                    if (++count == index[i]) {
                        fill[j] = true;
                        result[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
