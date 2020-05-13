class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        int[] curXor = new int[arr.length];
        curXor[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            curXor[i] = arr[i] ^ curXor[i - 1];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> lst = new LinkedList<>();
        lst.add(-1);
        map.put(0, lst);
        for (int i = 0; i < curXor.length; ++i) {
            List<Integer> idxs = map.getOrDefault(curXor[i], new LinkedList<>());
            if (map.containsKey(curXor[i])) {
                for (int idx : idxs) {
                    result += i - idx - 1;
                }
                idxs.add(i);
            }
            else {
                idxs.add(i);
            }
            map.put(curXor[i], idxs);
        }
        return result;
    }
}
