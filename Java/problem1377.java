class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) {
            return target == 1 && t >= 1 ? 1.0 : 0.0;
        }
        int[] father = new int[n + 1];
        int[] sonNum = new int[n + 1];
        int targetCount = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (edges[i][0] < edges[i][1]) {
                ++sonNum[edges[i][0]];
                father[edges[i][1]] = edges[i][0];
            }
            else {
                ++sonNum[edges[i][1]];
                father[edges[i][0]] = edges[i][1];
            }
            if (edges[i][0] == target || edges[i][1] == target) {
                ++targetCount;
            }
        }

        double probability = 1.0;
        int count = 0;
        int idx = target;
        while (father[idx] > 0) {
            probability /= sonNum[father[idx]];
            idx = father[idx];
            ++count;
        }
        if ((count < t && targetCount == 1 && target != 1) || count == t) {
            return probability;
        } 
        return 0.0;
    }
}
