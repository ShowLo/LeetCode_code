class Solution {

    private int getIndex(char c) {
        switch (c) {
            case 'c' :
                return 0;
            case 'r':
                return 1;
            case 'o':
                return 2;
            case 'a':
                return 3;
            case 'k':
                return 4;
            default:
                return -1;
        }
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] chars = croakOfFrogs.toCharArray();
        if (chars.length % 5 != 0) {
            return -1;
        }
        
        int[] counts = new int[5];
        int result = 0;
        for (char c : chars) {
            int idx = getIndex(c);
            ++counts[idx];
            for (int i = 0; i < idx; ++i) {
                if (counts[idx] > counts[i]) {
                    return -1;
                }
            }
            result = Math.max(result, counts[idx]);
            if (idx == 4) {
                for (int i = 0; i < 5; ++i) {
                    --counts[i];
                }
            }
        }
        return result;
    }
}
