class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int[] count = new int[100];
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
            ++count[n - 1];
        }
        List<Integer> result = new LinkedList<>();
        int cumSum = 0;
        for (int i = 99; i >= 0; --i) {
            for (int j = 0; j < count[i]; ++j) {
                cumSum += i + 1;
                result.add(i + 1);
                if (cumSum > totalSum - cumSum) {
                    return result;
                }
            }
        }
        return result;
    }
}
