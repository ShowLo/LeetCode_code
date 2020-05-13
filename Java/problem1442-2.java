class Solution {
    public int countTriplets(int[] arr) {
        int result = 0;
        int[] curXor = new int[arr.length];
        curXor[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            curXor[i] = arr[i] ^ curXor[i - 1];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int k = i + 1; k < arr.length; ++k) {
                int num = curXor[k] ^ (i == 0 ? 0 : curXor[i - 1]);
                if (num == 0) {
                    result += k - i;
                }
            }
        }
        return result;
    }
}
