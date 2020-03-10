class Solution {
    public int numTimesAllBlue(int[] light) {
        int count = 0, maxIdx = 0;
        for (int i = 0; i < light.length; ++i) {
            maxIdx = light[i] > maxIdx ? light[i] : maxIdx;
            if (maxIdx == i + 1) {
                ++count;
            }
        }
        return count;
    }
}
