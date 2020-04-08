class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        Arrays.sort(nums);
        int cumSum = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; --i)
        {
            cumSum += nums[i];
            result.add(nums[i]);
            if (cumSum > sum - cumSum) {
                break;
            }
        }
        return result;
    }
}
