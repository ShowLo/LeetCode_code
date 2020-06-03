class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hMax = 0, wMax = 0;
        int prev = 0;
        for (int hc : horizontalCuts) {
            hMax = Math.max(hc - prev, hMax);
            prev = hc;
        }
        hMax = Math.max(h - prev, hMax);
        prev = 0;
        for (int vc : verticalCuts) {
            wMax = Math.max(vc - prev, wMax);
            prev = vc;
        }
        wMax = Math.max(w - prev, wMax);
        return (int)((hMax * 1l * wMax) % 1000_000_007);
    }
}
