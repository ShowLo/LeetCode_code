class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (left == right - 1) {
                return Math.min(numbers[left], numbers[right]);
            }
            int middle = left + (right - left) / 2;
            if (numbers[left] == numbers[middle] && numbers[middle] == numbers[right]) {
                for (int i = left + 1; i <= right; ++i) {
                    if (numbers[i] < numbers[i - 1]) {
                        return numbers[i];
                    }
                }
                return numbers[left];
            }
            if (numbers[left] <= numbers[middle] && numbers[middle] <= numbers[right]) {
                return numbers[left];
            }
            if (numbers[left] > numbers[middle]) {
                right = middle;
            }
            else {
                left = middle;
            }
        }
        return numbers[0];
    }
}
