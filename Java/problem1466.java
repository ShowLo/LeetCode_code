class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> toNext = new HashMap<>();
        Map<Integer, List<Integer>> reverse = new HashMap<>();
        for (int[] c : connections) {
            if (toNext.containsKey(c[0])) {
                toNext.get(c[0]).add(c[1]);
            }
            else {
                List<Integer> item = new LinkedList<>();
                item.add(c[1]);
                toNext.put(c[0], item);
            }
            if (reverse.containsKey(c[1])) {
                reverse.get(c[1]).add(c[0]);
            }
            else {
                List<Integer> item = new LinkedList<>();
                item.add(c[0]);
                reverse.put(c[1], item);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int result = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (reverse.containsKey(node)) {
                for (int nextNode : reverse.get(node)) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                    }
                }
            }
            if (toNext.containsKey(node)) {
                for (int nextNode : toNext.get(node)) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                        ++result;
                    }
                }
            }
        }
        return result;
    }
}
