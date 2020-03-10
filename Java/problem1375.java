class Solution {
    public int numTimesAllBlue(int[] light) {
        boolean[] blue = new boolean[50001];
        boolean[] visited = new boolean[50001];
        blue[0] = true;
        int count = 0, maxIdx = 0;
        for (int i = 0; i < light.length; ++i) {
            int idx = light[i];
            maxIdx = idx > maxIdx ? idx : maxIdx;
            visited[idx] = true;
            if (blue[idx - 1]) {
                blue[idx] = true;
                if (maxIdx == idx) {
                    ++count;
                }
                else {
                    ++idx;
                    while (idx <= maxIdx && visited[idx]) {
                        blue[idx++] = true;
                    }
                    if (idx == maxIdx + 1) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}
