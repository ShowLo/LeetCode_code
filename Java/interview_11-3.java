class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (left == right - 1) {
                return Math.min(numbers[left], numbers[right]);
            }
            int middle = left + (right - left) / 2;
            if (numbers[middle] > numbers[right]) {
                left = middle;
            }
            else if (numbers[middle] < numbers[right]) {
                right = middle;
            }
            else {
                --right;
            }
        }
        return numbers[0];
    }
}
