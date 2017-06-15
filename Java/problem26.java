public class Solution
{
    public int removeDuplicates(int[] nums) 
    {
        int result = 1;
        int length = nums.length;
        if(length == 0)
            return 0;
        if(length == 1)
            return 1;
        for(int i = 1; i < length; ++i)
        {
            if(nums[i] == nums[i - 1])  //当前元素与前一个元素一样，跳过
                continue;
            else                        //否则的话说明有一个新的数
            {
                nums[result] = nums[i];
                result += 1;
            }
        }
        return result;
    }
}