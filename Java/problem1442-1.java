class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        int[] curXor = new int[arr.length];
        curXor[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            curXor[i] = arr[i] ^ curXor[i - 1];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                for (int k = j; k < arr.length; ++k) {
                    int a = curXor[j - 1] ^ (i == 0 ? 0 : curXor[i - 1]);
                    int b = curXor[k] ^ curXor[j - 1];
                    if (a == b) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }
}
