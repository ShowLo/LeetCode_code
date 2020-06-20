class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] values = new int[map.size()];
        int i = 0;
        for (int v : map.values()) {
            values[i++] = v;
        }
        Arrays.sort(values);
        int count = 0;
        for (i = 0; i < values.length; ++i) {
            if (values[i] <= k) {
                ++count;
                k -= values[i];
            }
        }
        return values.length - count;
    }
}
