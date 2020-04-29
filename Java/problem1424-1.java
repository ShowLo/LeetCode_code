class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> idx2list = new TreeMap<>();
        int count = 0;
        int i = 0;
        for (List<Integer> num : nums) {
            int j = 0;
            for (int n : num) {
                if (idx2list.containsKey(i + j)) {
                    idx2list.get(i + j).add(n);
                }
                else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(n);
                    idx2list.put(i + j, newList);
                }
                ++j;
                ++count;
            }
            ++i;
        }
        int[] result = new int[count];
        int idx = 0;
        for (List<Integer> list : idx2list.values()) {
            for (i = list.size() - 1; i >= 0; --i) {
                result[idx++] = list.get(i);
            }
        }
        return result;
    }
}
