public class Solution
{
    public int search(int[] nums, int target)
    {
        int length = nums.length;
        if(length == 0)
            return -1;
        if(target == nums[0])
            return 0;                           //目标值比列表中第一个值大，往后找目标值
        if(target > nums[0])
        {
            for(int i = 1; i < length; ++i)
            {
                if(target == nums[i])
                    return i;
                else if(nums[i] < nums[i - 1])  //如果列表中当前值比前面值大，说明到了反转点，此时后面的值都比目标值小
                    return -1;
            }
        }
        if(target < nums[0])
        {
            for(int i = length - 1; i > 0; --i) //目标值比列表中第一值小，只能从最后面往前找
            {
                if(target == nums[i])
                    return i;
                else if(nums[i - 1] > nums[i])  //如果列表中当前值比后面值大说明到了反转点，此时前面的值都比目标值大
                    return -1;
            }
        }
        return -1;
    }
}