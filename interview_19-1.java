class Solution {
    private char[] sChar;
    private char[] pChar;
    private boolean match(int sIdx, int pIdx) {
        int sLen = sChar.length - sIdx, pLen = pChar.length - pIdx;
        if (pLen == 0) {
            // p为空的情况下必须s也为空才能匹配成功
            return sLen == 0;
        }
        // 根据p的第二位是否为*，分两种情况
        if (pLen >= 2 && pChar[pIdx + 1] == '*') {
            // 可以匹配任意个p[pIdx]，尝试匹配0个和1个，注意超过1个的会在match(sIdx+1, pIdx)里面被递归到
            return match(sIdx, pIdx + 2) || (sLen > 0 && (sChar[sIdx] == pChar[pIdx] || pChar[pIdx] == '.') && match(sIdx + 1, pIdx));
        }
        else {
            // 第二位不为*，那么当前位就必须匹配上了，然后再看后面的是否匹配
            return sLen > 0 && (sChar[sIdx] == pChar[pIdx] || pChar[pIdx] == '.') && match(sIdx + 1, pIdx + 1);
        }
    }
    
    public boolean isMatch(String s, String p) {
        sChar = s.toCharArray();
        pChar = p.toCharArray();
        return match(0, 0);
    }
}
