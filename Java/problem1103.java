class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int N = (int)Math.ceil((Math.sqrt(1 + 8. * candies) - 1) / 2);
        int k = (int)Math.ceil(N * 1. / num_people) - 1;
        int addition = num_people * k * (k - 1) / 2;
        int[] ans = new int[num_people];
        for (int i = 0; i < num_people; ++i) {
            ans[i] = k * (i + 1) + addition;
        }
        int lastIdx = N % num_people;
        if (lastIdx == 0) {
            lastIdx = num_people;
        }
        --lastIdx;
        for (int i = 0; i < lastIdx; ++i) {
            ans[i] += k * num_people + i + 1;
        }
        ans[lastIdx] += candies - N * (N - 1) / 2;
        return ans;
    }
}
