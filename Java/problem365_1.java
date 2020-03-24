class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == z) {
                return true;
            }
            if (n <= y && set.add(n + x)) {
                queue.offer(n + x);
            }
            if (n <= x && set.add(n + y)) {
                queue.offer(n + y);
            }
            if (n >= x && set.add(n - x)) {
                queue.offer(n - x);
            }
            if (n >= y && set.add(n - y)) {
                queue.offer(n - y);
            }
        }
        return false;
    }
}
