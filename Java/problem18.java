public class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);                                       //先排序
        int first = 0, second, third, fourth, sum12, sum, error;
        while(first < length - 3)                               //第一个数最右的位置也只能到倒数第四
        {
            second = first + 1;
            while(second < length - 2)                          //第二个数最右的位置也只能到倒数第三
            {
                third = second + 1;
                fourth = length - 1;
                sum12 = nums[first] + nums[second];
                while(third < fourth)
                {
                    sum = sum12 + nums[third] + nums[fourth];
                    error = target - sum;
                    if(error == 0)                              //如果四个数之和刚好等于目标值，加入结果list
                    {
                        result.add(Arrays.asList(nums[first],nums[second],nums[third],nums[fourth]));
                        while(third < length - 1 && nums[third] == nums[third + 1])
                            ++third;
                        ++third;                                //将第三个数的索引移动下一个不一样的数上去
                        while(second < length - 1 && nums[second] == nums[second + 1])
                            ++second;                           //将第二个数的索引移动到最后一个一样的数上
                        while(first < length - 1 && nums[first] == nums[first + 1])
                            ++first;                            //将第一个数的索引移动到最后一个一样的数上
                    }
                    else if(error > 0)                          //当四个数之和小于目标值，第三个数的索引右移到一个不同的数上
                    {
                        while(third < length - 1 && nums[third] == nums[third + 1])
                            ++third;
                        ++third;
                    }
                    else                                        //当四个数之和大于目标值，第四个数的索引左移到一个不同的数上
                    {
                        while(fourth > 0 && nums[fourth] == nums[fourth - 1])
                            --fourth;
                        --fourth;
                    }
                }
                ++second;
            }
            ++first;
        }
        return result;
    }
}