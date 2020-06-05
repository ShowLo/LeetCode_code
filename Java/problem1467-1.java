class Solution {
    private int[] right;
    private int[] left;
    private int n;
    private double result;
    private double[] factorial;

    private double countOneSide(int[] item) {
        // 计算左边/右边盒子里球的排列组合数
        double res = factorial[n];
        for (int i : item) {
            if (i > 1) {
                res /= factorial[i];
            }
        }
        return res;
    }

    private int countColor(int[] item) {
        // 计算盒子里有多少种颜色的球
        int res = 0;
        for (int i : item) {
            if (i > 0) {
                ++res;
            }
        }
        return res;
    }

    private boolean dfs(int idx, int leftNum) {
        int leftColor = countColor(left), rightColor = countColor(right);
        if (leftColor > rightColor || leftNum > n) {
            // 剪枝
            return false;
        }
        if (leftNum == n) {
            // 左边和右边盒子里球的数量已经一样了
            if (leftColor == rightColor) {
                result += countOneSide(left) * countOneSide(right);
            }
            // 这里返回false，因为再从右边盒子往左边盒子拿球只能使得左边球的数量大于n
            return false;
        }
        if (idx >= right.length) {
            return true;
        }
        boolean cont = true;
        // 从右边盒子里中取i个第idx种颜色放到左边盒子里去
        for (int i = 0; i <= right[idx] && cont; ++i) {
            left[idx] += i;
            right[idx] -= i;
            cont = dfs(idx + 1, leftNum + i);
            // 回溯
            left[idx] -= i;
            right[idx] += i;
        }
        return true;
    }

    public double getProbability(int[] balls) {
        // 先将所有球放在右边盒子
        right = balls;
        // 左边盒子一开始是空的
        left = new int[balls.length];
        n = 0;
        for (int b : balls) {
            n += b;
        }
        factorial = new double[n + 1];
        factorial[1] = 1.0;
        for (int i = 2; i <= n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        n /= 2;
        result = 0.0;
        dfs(0, 0);
        double totalCount = factorial[n * 2];
        for (int b : balls) {
            totalCount /= factorial[b];
        }
        return result / totalCount;
    }
}
