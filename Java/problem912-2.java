class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private int random_partition(int[] nums, int left, int right) {
        int idx = left + (int)Math.random() % (right - left + 1);
        swap(nums, idx, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left - 1;
        int pivot = nums[right];
        for (int j = left; j < right; ++j) {
            if (nums[j] < pivot) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, right);
        return i;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = random_partition(nums, left, right);
        quickSort(nums, left, middle - 1);
        quickSort(nums, middle + 1, right);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
