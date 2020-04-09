class Solution {
    public int numSteps(String s) {
        int count = 0;
        boolean carry = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (!carry && i == 0) {
                // 对应于100...000这种情况，避免进入后面的+1再除以2
                break;
            }
            if ((carry && s.charAt(i) == '0') || (!carry && s.charAt(i) == '1')) {
                // 有进位且当前位为0或没进位且当前位为1都会导致当前位实际为1，需要两步：+1然后除以2
                ++count;
                carry = true;
            }
            // 除以2的那一步
            ++count;
        }
        return count;
    }
}
