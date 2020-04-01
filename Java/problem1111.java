class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        char[] str = seq.toCharArray();
        int strLen = str.length;
        int stackLen = 0;
        int[] result = new int[strLen];
        for (int i = 0; i < strLen; ++i) {
            if (str[i] == '(') {
                result[i] = ++stackLen % 2;
            }
            else {
                result[i] = stackLen-- % 2;
            }
        }
        return result;
    }
}
