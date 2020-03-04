class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum2num = numbers[left] + numbers[right];
            if (sum2num == target) {
                return new int[] {left + 1, right + 1};
            }
            else if (sum2num < target) {
                ++left;
            }
            else {
                --right;
            }
        }
        return null;
    }
}
