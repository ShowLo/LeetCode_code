public class Solution 
{
    public int[] searchRange(int[] nums, int target)
    {
        int onePosition = binarySearch(nums, target);   //先找到一个目标值的位置
        if(onePosition == -1)
            return new int[]{-1,-1};
        int left = onePosition - 1, right = onePosition + 1;
        while(right < nums.length)                      //然后向右拓展
        {
            if(nums[right] == target)
                ++right;
            else
                break;
        }
        while(left >= 0)                                //向左拓展
        {
            if(nums[left] == target)
                --left;
            else
                break;
        }
        return new int[] {left + 1,right - 1};
    }
    private int binarySearch(int[] nums, int target)    //二分查找函数
    {
        int left = 0, right = nums.length - 1;
        int middle, middleNum;
        while(left <= right)
        {
            middle = (left + right) / 2;                //中点位置
            middleNum = nums[middle];
            if(middleNum == target)
                return middle;
            else if(middleNum > target)                 //比目标值大，找左边的
                right = middle - 1;
            else                                        //比目标值小，找右边的
                left = middle + 1;
        }
        return -1;
    }
}