class Solution {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int random_partition(int[] arr, int left, int right) {
        int idx = left + (int)(Math.random() * (right - left + 1));
        swap(arr, left, idx);
        return partition(arr, left, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                --j;
            }
            while (i < j && arr[i] <= pivot) {
                ++i;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    /*
    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = random_partition(arr, left, right);
        quickSort(arr, left, middle - 1);
        quickSort(arr, middle + 1, right);
    }
    */

    private void quickSelect(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int middle = random_partition(arr, left, right);
        int num = middle - left + 1;
        if (k == num) {
            return;
        }
        if (k < num) {
            quickSelect(arr, left, middle - 1, k);
        }
        else {
            quickSelect(arr, middle + 1, right, k - num);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {        
        int[] result = new int[k];
        //quickSort(arr, 0, arr.length - 1);
        quickSelect(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; ++i) {
            result[i] = arr[i];
        }
        return result;
        
    }
}
