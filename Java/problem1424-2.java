class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int MaxLen = 100_000;
        List<Integer>[] idx2list = new ArrayList[MaxLen];
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; --i) {
            List<Integer> item = nums.get(i);
            int size = item.size();
            for (int j = 0; j < size; ++j) {
                if (idx2list[i + j] != null) {
                    idx2list[i + j].add(item.get(j));
                }
                else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(item.get(j));
                    idx2list[i + j] = newList;
                }
                ++count;
            }
        }
        int[] result = new int[count];
        int idx = 0;
        for (List<Integer> item : idx2list) {
            if (item == null) {
                break;
            }
            for (int value : item) {
                result[idx++] = value;
            }
        }
        return result;
    }
}
