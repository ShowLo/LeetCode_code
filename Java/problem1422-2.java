class Solution {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int count = 0, result = 0;
        
        for (int i = 0; i < N - 1; ++i) {
            // 先统计左边0的个数
            if (chars[i] == '0') {
                ++count;
            }
        }
        for (int i = N - 1; i > 0; --i) {
            // 再从右往左遍历，遇到1说明右边1的个数增加了，但左边0的个数不变，所以得分+1
            if (chars[i] == '1') {
                ++count;
            }
            // 在非最后位置遇到0的话说明右边1的个数不变，但左边0的个数减少，所以得分-1
            else if (i < N - 1) {
                --count;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
