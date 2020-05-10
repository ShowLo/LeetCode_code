class Solution {

    private int getIdx(char c) {
        switch (c) {
            case ' ' : return 0;
            case '+' :
            case '-' : return 1;
            case '.' : return 3;
            case 'e' : return 4;
            default :
                if (c >= '0' && c <= '9') {
                    return 2;
                }
                return -1;
        }
    }
    
    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                                       {-1,-1, 6, 2,-1},
                                       {-1,-1, 3,-1,-1},
                                       { 8,-1, 3,-1, 4},
                                       {-1, 7, 5,-1,-1},
                                       { 8,-1, 5,-1,-1},
                                       { 8,-1, 6, 3, 4},
                                       {-1,-1, 5,-1,-1},
                                       { 8,-1,-1,-1,-1}};
        int state = 0, idx = 0;
        for (char c : chars) {
            idx = getIdx(c);
            if (idx < 0) {
                return false;
            }
            state = transfer[state][idx];
            if (state < 0) {
                return false;
            }
        }
        // 最后多加一个空格以统一处理
        state = transfer[state][0];
        return state == 8;
    }
}
