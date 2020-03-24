class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] speedAndEff = new int[n][2];
        for (int i = 0; i < n; ++i) {
            speedAndEff[i][0] = speed[i];
            speedAndEff[i][1] = efficiency[i];
        }
        Arrays.sort(speedAndEff, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        Queue topk = new PriorityQueue<Integer>(k);
        long maxResult = 0, totalSpeed = 0;
        for (int i = 0; i < n; ++i) {
            if (i < k) {
                topk.offer(speedAndEff[i][0]);
                totalSpeed += speedAndEff[i][0];
                maxResult = Math.max(maxResult, totalSpeed * speedAndEff[i][1]);
            }
            else {
                if (speedAndEff[i][0] > (int)topk.peek()) {
                    totalSpeed = totalSpeed - (int)topk.poll() + speedAndEff[i][0];
                    topk.offer(speedAndEff[i][0]);
                    maxResult = Math.max(maxResult, totalSpeed * speedAndEff[i][1]);
                }
            }
        }
        return (int)(maxResult % 1000000007);
    }
}
