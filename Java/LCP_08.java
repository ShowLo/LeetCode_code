class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int N = increase.length;
        // 原地操作，计算累加和
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < 3; ++j) {
                increase[i][j] += increase[i - 1][j];
            }
        }
        
        // 大于等于i至少需要c[i]/r[i]/h[i]次
        int[] c = new int[increase[N - 1][0] + 1];
        int[] r = new int[increase[N - 1][1] + 1];
        int[] h = new int[increase[N - 1][2] + 1];
        int count = 1;
        for (int i = 1; i <= increase[0][0]; ++i) {
            c[i] = count;
        }
        for (int i = 1; i <= increase[0][1]; ++i) {
            r[i] = count;
        }
        for (int i = 1; i <= increase[0][2]; ++i) {
            h[i] = count;
        }
        for (int i = 1; i < N; ++i) {
            ++count;
            // 注意如果increase为0的话就不用修改次数了
            if (increase[i][0] > increase[i - 1][0]) {
                for (int j = increase[i][0]; j > 0 && c[j] == 0; --j) {
                    c[j] = count;
                }
            }
            if (increase[i][1] > increase[i - 1][1]) {
                for (int j = increase[i][1]; j > 0 && r[j] == 0; --j) {
                    r[j] = count;
                }
            }
            if (increase[i][2] > increase[i - 1][2]) {
                for (int j = increase[i][2]; j > 0 && h[j] == 0; --j) {
                    h[j] = count;
                }
            }
        }

        int[] result = new int[requirements.length];
        int idx = 0;
        for (int[] require : requirements) {
            if (require[0] > increase[N - 1][0] || require[1] > increase[N - 1][1] || require[2] > increase[N - 1][2]) {
                result[idx++] = -1;
                continue;
            }
            result[idx++] = Math.max(c[require[0]], Math.max(r[require[1]], h[require[2]]));
        }
        
        return result;
    }
}
