public class Solution
{
    public void nextPermutation(int[] nums) 
    {
        int length = nums.length;
        int largerIndex, value;
        for(int i = length - 1; i > 0; --i)
        {
            if(nums[i] > nums[i - 1])                                   //找到第一个后面数字大于前面数字的位置
            {
                largerIndex = i;                                        //记录比前面数字大的最小的数的位置
                value = nums[i - 1];
                for(int j = largerIndex + 1; j < length; ++j)
                {
                    if(nums[j] > value && nums[j] < nums[largerIndex])
                        largerIndex = j;
                }
                int temp = nums[largerIndex];
                for(int k = largerIndex; k > i - 1; --k)
                    nums[k] = nums[k - 1];
                nums[i - 1] = temp;
                int[] subNums = Arrays.copyOfRange(nums, i, length);    //将其后面的数进行排序
                Arrays.sort(subNums);
                for(int j = length - 1, k = length - i - 1; k >= 0; --j, --k)
                    nums[j] = subNums[k];
                return;
            }
        }
        Arrays.sort(nums);
    }
}