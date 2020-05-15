class Solution {
    private Map<Integer, List<Integer>> root2son;
    private boolean[] visited;

    private int visit(int node, List<Boolean> hasApple) {
        visited[node] = true;
        List<Integer> lst = root2son.get(node);
        int result = 0;
        for (int nextNode : lst) {
            if (!visited[nextNode]) {
                result += visit(nextNode, hasApple);
            }
        }
        if (result == 0) {
            return hasApple.get(node) ? 2 : 0;
        }
        else {
            return result + 2;
        }
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        root2son = new HashMap<>();
        visited = new boolean[n];
        for (int[] edge : edges) {
            if (root2son.containsKey(edge[0])) {
                root2son.get(edge[0]).add(edge[1]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                root2son.put(edge[0], list);
            }
            if (root2son.containsKey(edge[1])) {
                root2son.get(edge[1]).add(edge[0]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                root2son.put(edge[1], list);
            }
        }
        int result = visit(0, hasApple);
        return result == 0 ? 0 : result - 2;
    }
}
