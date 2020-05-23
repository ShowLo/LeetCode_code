class Solution:
    def numPoints(self, points: List[List[int]], r: int) -> int:
        N = len(points)
        result = 1
        for i in range(N):
            for j in range(N):
                if i == j:
                    continue
                d = math.sqrt(((points[i][0] - points[j][0])**2 + (points[i][1] - points[j][1])**2)) / 2
                if d > r:
                    continue
                x = (points[i][0] + points[j][0]) / 2
                y = (points[i][1] + points[j][1]) / 2
                h = math.sqrt(r**2 - d**2)
                center_x = x - h * (y - points[i][1]) / d
                center_y = y + h * (x - points[i][0]) / d
                count = 0
                for point in points:
                    if (point[0] - center_x)**2 + (point[1] - center_y)**2 <= r**2 + 1e-7:
                        count += 1
                result = max(result, count)
        return result
