class Solution {
    private int[] prev;
    private int[][] backup;

    private int find(int node) {
        if (prev[node] != prev[prev[node]]) {
            prev[node] = find(prev[node]);
        }
        return prev[node];
    }

    public int kruskal(int[][] edges, int n, int k, boolean removeK) {
        for (int i = 0; i < n; ++i) {
            prev[i] = i;
        }
        int sum = 0;
        int count = 0;
        if (!removeK && k >= 0) {
            prev[backup[k][1]] = backup[k][0];
            sum += backup[k][2];
            ++count;
        }
        for (int i = 0; i < edges.length; ++i) {
            if (removeK && edges[i] == backup[k]) {
                continue;
            }
            int prev1 = find(edges[i][0]);
            int prev2 = find(edges[i][1]);
            if (prev1 == prev2) {
                continue;
            }
            prev[prev2] = prev1;
            sum += edges[i][2];
            if (++count == n - 1) {
                return sum;
            }
        }
        return Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        prev = new int[n];
        backup = edges.clone();
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[2] - i2[2];
            }
        });
        int minSum = kruskal(edges, n, -1, false);
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());
        result.add(new LinkedList<Integer>());
        for (int i = 0; i < edges.length; ++i) {
            if (kruskal(edges, n, i, true) > minSum) {
                result.get(0).add(i);
            }
            else if (kruskal(edges, n, i, false) == minSum) {
                result.get(1).add(i);
            }
        }
        return result;
    }
}
