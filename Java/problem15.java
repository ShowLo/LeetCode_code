public class Solution 
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);                                  //先排序
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int left, right, now_num, left_num, right_num, sumLR;
        for(int i = 0; i < length - 2; ++ i)                //只遍历到倒数第3个数
        {
            left = i + 1;                   
            right = length - 1;
            now_num = nums[i];
            while(left != right)                            //当左指针和右指针相遇的时候结束一轮循环
            {
                left_num = nums[left];
                right_num = nums[right];
                sumLR = left_num + right_num;
                if(sumLR == -now_num)                       //三个数的和为0
                {
                    result.add(Arrays.asList(now_num,left_num,right_num));
                    ++left;                                 //这个时候左指针右移直到所在位置的数不跟其左边的一样
                    while(left < right && left_num == nums[left])
                        ++left;
                    while(i < length - 1 && now_num == nums[i + 1])
                        ++i;                                //第一个数的位置也需右移到另一个不一样的数上去
                }
                else if(sumLR < -now_num)                   //当三个数的和小于零时，左指针右移
                    ++left;
                else                                        //当三个数的和大于零时，右指针左移
                    --right;
            }
        }
        return result;
    }
}