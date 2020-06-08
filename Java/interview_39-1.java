class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            if (count > half) {
                return n;
            }
            map.put(n, count);
        }
        return -1;
    }
}
