class Solution {
    public int subarraySum(int[] nums, int k) {
        int numsLen = nums.length, count = 0;
        int[] cumulativeSum = new int[numsLen];
        cumulativeSum[0] = nums[0];
        for (int i = 1; i < numsLen; ++i) {
            cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
        }
        Map<Integer, Integer> cumuSum2count = new HashMap<>();
        cumuSum2count.put(k, 1);
        for (int i : cumulativeSum) {
            if (cumuSum2count.containsKey(i)) {
                count += cumuSum2count.get(i);
            }
            int nextCumuSum = i + k;
            if (cumuSum2count.containsKey(nextCumuSum)) {
                cumuSum2count.put(nextCumuSum, cumuSum2count.get(nextCumuSum) + 1);
            }
            else {
                cumuSum2count.put(nextCumuSum, 1);
            }
        }
        return count;
    }
}
