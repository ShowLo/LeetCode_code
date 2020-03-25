class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int L = index.length;
        List<Integer> lst = new LinkedList<Integer>();
        for (int i = 0; i < L; ++i) {
            lst.add(index[i], nums[i]);
        }
        int[] result = new int[L];
        for (int i = 0; i < L; ++i) {
            result[i] = lst.get(i);
        }
        return result;
    }
}
