class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int n : nums) {
            if (visited[n]) {
                return n;
            }
            visited[n] = true;
        }
        return 0;
    }
}
