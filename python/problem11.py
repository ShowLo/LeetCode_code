class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height);
        maxWater = min(height[0],height[-1]) * (length - 1);				#初始化最大面积为最左最右板所围成
        left,right = 0,length - 1;
        for i in range(length - 1):
            if height[left] < height[right]:								#左板较矮，左板右移
                left += 1;
                water = min(height[left],height[right]) * (right - left);	#计算所围成面积，更大的话就更新
                if water > maxWater:
                    maxWater = water;
            else:															#右板较矮，右板左移
                right -= 1;
                water = min(height[left],height[right]) * (right - left);
                if water > maxWater:
                    maxWater = water;
        return maxWater;