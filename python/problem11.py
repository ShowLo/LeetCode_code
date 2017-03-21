class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height);
        maxWater = min(height[0],height[-1]) * (length - 1);
        left,right = 0,length - 1;
        for i in range(length - 1):
            if height[left] < height[right]:
                left += 1;
                water = min(height[left],height[right]) * (right - left);
                if water > maxWater:
                    maxWater = water;
            else:
                right -= 1;
                water = min(height[left],height[right]) * (right - left);
                if water > maxWater:
                    maxWater = water;
        return maxWater;