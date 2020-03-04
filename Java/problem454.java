class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0, num;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                num = 0 - a - b;
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
                else {
                    map.put(num, 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                num = c + d;
                if (map.containsKey(num)) {
                    count += map.get(num);
                }
            }
        }
        return count;
    }
}
