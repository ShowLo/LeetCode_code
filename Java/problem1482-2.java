class Solution {
    private Set<Integer> set;

    private boolean isValid(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int curSum = 0;
        for (int bd : bloomDay) {
            if (bd <= day) {
                ++curSum;
            }
            else {
                curSum = 0;
            }
            if (curSum >= k) {
                if (++count >= m) {
                    break;
                }
                curSum = 0;
            }
        }
        return count >= m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        int maxDay = 0;
        for (int bd : bloomDay) {
            maxDay = Math.max(maxDay, bd);
        }
        int left = 1, right = maxDay;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isValid(bloomDay, middle, m, k)) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }
        return right;
    }
}
