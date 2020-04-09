class Solution {
    public int numSteps(String s) {
        int count = 0;
        int i = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i > 0) {
            if (chars[i] == '0') {
                ++count;
                --i;
            }
            else {
                // 奇数+1之后会产生进位，需要考虑前面有多少个连续的1
                ++count;
                // 有多少个连续的1就会在+1之后产生多少个0，也就需要多少次除以2
                while (i > 0 && chars[i] == '1') {
                    ++count;
                    --i;
                }
                if (i > 0) {
                    chars[i] = '1';
                }
                else {
                    // 一直到首位都是1的话已经可以得到结果了
                    return count + 1;
                }
            }
        }
        return count;
    }
}
