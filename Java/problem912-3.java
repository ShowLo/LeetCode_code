class Solution {
    
    public int[] sortArray(int[] nums) {
        int N = 100001;
        int bias = 50000;
        int[] countNums = new int[N];
        for (int num : nums) {
            ++countNums[num + bias];
        }
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < countNums[i]; ++j) {
                nums[count++] = i - bias;
            }
        }
        return nums;
    }
}
