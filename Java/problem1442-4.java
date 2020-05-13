class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        int curXor = 0;
        // int[0]:出现次数，int[1]：多个索引（i+1）累加和
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[] {1, 0});
        for (int i = 0; i < arr.length; ++i) {
            curXor ^= arr[i];
            int[] countAndSum = map.getOrDefault(curXor, new int[2]);
            if (map.containsKey(curXor)) {
                result += countAndSum[0] * i - countAndSum[1];
                ++countAndSum[0];
                countAndSum[1] += i + 1;
            }
            else {
                countAndSum[0] = 1;
                countAndSum[1] = i + 1;
            }
            map.put(curXor, countAndSum);
        }
        return result;
    }
}
