class Solution {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        char[] strs = new char[(chars.length + 1) / 2];
        char[] nums = new char[(chars.length + 1) / 2];
        int strIdx = 0, numIdx = 0;
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                if (strIdx >= strs.length) {
                    return "";
                }
                strs[strIdx++] = c;
            }
            else {
                if (numIdx >= strs.length) {
                    return "";
                }
                nums[numIdx++] = c;
            }
        }
        char[] result = new char[strIdx + numIdx];
        if (strIdx >= numIdx) {
            for (int i = 0; i < strIdx; ++i) {
                result[2 * i] = strs[i];
                
            }
            for (int i = 0; i < numIdx; ++i) {
                result[2 * i + 1] = nums[i];
            }
        }
        else {
            for (int i = 0; i < numIdx; ++i) {
                result[2 * i] = nums[i];
                
            }
            for (int i = 0; i < strIdx; ++i) {
                result[2 * i + 1] = strs[i];
            }
        }
        return new String(result);
    }
}
