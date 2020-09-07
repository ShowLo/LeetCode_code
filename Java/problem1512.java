class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int c : count.values()) {
            res += c * (c - 1) / 2;
        }
        return res;
    }
}
