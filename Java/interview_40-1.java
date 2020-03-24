class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int N = 10001;
        int[] record = new int[N];
        for (int i = 0; i < arr.length; ++i) {
            ++record[arr[i]];
        }
        int[] result = new int[k];
        for (int i = 0, idx = 0; i < N; ++i) {
            if (record[i] > 0) {
                for (int j = 0; j < record[i] && idx < k; ++j) {
                    result[idx++] = i;
                }
                if (idx == k) {
                    break;
                }
            }
        }
        return result;
    }
}
