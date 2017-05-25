public class Solution
{
    public int maxArea(int[] height)
    {
        int len = height.length;
        int water, maxWater = height[0] < height[len - 1] ? height[0] : height[len - 1];
        maxWater *= len - 1;                    //初始化最大面积为最左最右板所围成
        int left = 0, right = len - 1;
        for(int i = 0; i < len - 1; ++i)
        {
            if(height[left] < height[right])    //左板较矮，左板右移
            {
                ++left;
                water = height[left] < height[right] ? height[left] : height[right];
                water *= right - left;          //计算所围成面积，更大的话就更新
                if(water > maxWater)        
                    maxWater = water;
            }
            else                                //右板较矮，右板左移
            {
                --right;
                water = height[left] < height[right] ? height[left] : height[right];
                water *= right - left;
                if(water > maxWater)
                    maxWater = water;
            }
        }
        return maxWater;
    }
}