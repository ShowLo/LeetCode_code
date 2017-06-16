public class Solution
{
    public int removeElement(int[] nums, int val) 
    {
        int length = nums.length;
        int result = 0;
        for(int i = 0; i < length; ++i)
        {
            if(nums[i] == val)
                continue;
            else
            {
                nums[result] = nums[i];
                ++result;
            }
        }
        return result;
    }
}