class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        for (int i = 0; i < k; ++i) {
            result += cardPoints[i];
        }
        int curSum = result;
        for (int i = 0; i < k; ++i) {
            curSum = curSum - cardPoints[k - i - 1] + cardPoints[cardPoints.length - 1 - i];
            result = Math.max(result, curSum);
        }
        return result;
    }
}
