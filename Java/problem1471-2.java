class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2];
        int left = 0, right = n - 1;
        int idx = 0;
        int[] result = new int[k];
        while (idx < k) {
            if (m - arr[left] > arr[right] - m) {
                result[idx++] = arr[left++];
            }
            else {
                result[idx++] = arr[right--];
            }
        }
        return result;
    }
}
