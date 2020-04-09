class Solution {
    public int numSteps(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        while (left < right) {
            if (chars[right] == '0') {
                ++count;
                --right;
            }
            else {
                // 奇数的时候必定是先+1（所以有进位）变为偶数再除以2，两步一块做了
                count += 2;
                boolean carry = true;
                --right;
                for (int i = right; i >= left; --i) {
                    if (carry) {
                        if (chars[i] == '1') {
                            chars[i] = '0';
                            if (i == left) {
                                // 第一位也产生进位，说明这个数是111...111的格式
                                // +1后是1000...000，可以知道接下来还需要多少次除以2的操作得到1
                                return count + right - left + 1;
                            }
                        }
                        else {
                            chars[i] = '1';
                            carry = false;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
