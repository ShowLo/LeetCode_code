class Solution {
    public int[] printNumbers(int n) {
        int maxNum = 0;
        for (int i = 0; i < n; ++i) {
            maxNum = maxNum * 10 + 9; 
        }
        int[] result = new int[maxNum];
        for (int i = 1; i <= maxNum; ++i) {
            result[i - 1] = i;
        }
        return result;
    }
}
