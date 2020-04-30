class Solution {
    private Map<Integer, List<Integer>> map;
    private int count;
    
    private void visit(int r0, int k, int n) {
        if (k == 0) {
            if (r0 == n - 1) {
                ++count;
            }
            return;
        }
        if (map.containsKey(r0)) {
            for (int i : map.get(r0)) {
                visit(i, k - 1, n);
            }
        }
        else {
            return;
        }
    }
    
    public int numWays(int n, int[][] relation, int k) {
        map = new HashMap<>();
        for (int[] r : relation) {
            List<Integer> lst = map.getOrDefault(r[0], new LinkedList<Integer>());
            lst.add(r[1]);
            map.put(r[0], lst);
        }
        count = 0;
        visit(0, k, n);
        return count;
    }
}
