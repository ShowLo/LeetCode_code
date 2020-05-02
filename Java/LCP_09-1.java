class Solution {
    public int minJump(int[] jump) {
        // arrived[i]:从编号i开始可以通过count次越过N-1
        boolean[] arrived = new boolean[jump.length];
        int count = 0;
        int mostLeft = jump.length - 1;
        while (true) {
            for (int i = 0; i < jump.length; ++i) {
                if (arrived[i]) {
                    ++i;
                    while (i <= mostLeft) {
                        arrived[i++] = true;
                    }
                    break;
                }
                if (i + jump[i] >= jump.length || arrived[i + jump[i]]) {
                    arrived[i] = true;
                }
            }
            while (mostLeft >= 0 && arrived[mostLeft]) {
                --mostLeft;
            }
            ++count;
            if (arrived[0]) {
                break;
            }
        }
        return count;
    }
}
