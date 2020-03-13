class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (A[index1] > B[index2]) {
                A[index1 + index2 + 1] = A[index1];
                --index1;
            }
            else {
                A[index1 + index2 + 1] = B[index2];
                --index2;
            }
        }
        if (index1 == -1) {
            while (index2 >= 0) {
                A[index2] = B[index2];
                --index2;
            }
        }
    }
}
