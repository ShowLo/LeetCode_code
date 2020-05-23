class Solution {
    public int numPoints(int[][] points, int r) {
        int N = points.length;
        int result = 1, count;
        int r2 = r * r;
        double d, h, x, y, center_x, center_y;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == j) {
                    continue;
                }
                d = Math.sqrt((points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1])) / 2;
                if (d * d > r2) {
                    continue;
                }
                h = Math.sqrt(r2 - d * d);
                x = (points[i][0] + points[j][0]) / 2.0;
                y = (points[i][1] + points[j][1]) / 2.0;
                center_x = x - h * (y - points[i][1]) / d;
                center_y = y + h * (x - points[i][0]) / d;

                count = 0;
                for (int[] point : points) {
                    if ((point[0] - center_x) * (point[0] - center_x) + (point[1] - center_y) * (point[1] - center_y) <= r2 + 1e-7) {
                        ++count;
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
