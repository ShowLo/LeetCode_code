public class Solution
{
    public int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);                      //先排序
        int length = nums.length;
        int min = Integer.MAX_VALUE;            //最小差值初始化为正无穷
        int result = 0, now_num, left, right, left_num, right_num, threeSum, error;
        for(int i = 0; i < length - 2; ++i)     //只需遍历到倒数第三个数
        {
            now_num = nums[i];
            left = i + 1;
            right = length - 1;
            while(left < right)                 //左指针和右指针相遇时结束一轮循环
            {
                left_num = nums[left];
                right_num = nums[right];
                threeSum = now_num + left_num + right_num;
                error = target - threeSum;      //目标值和当前三个数和的差
                if(error == 0)                  //刚刚好相等，直接返回目标值
                    return target;
                else if(error > 0)              //三个数的和偏小，左指针右移
                {
                    ++left;
                    if(error < min)
                    {
                        min = error;
                        result = threeSum;
                    }
                }
                else                            //三个数的和偏大，右指针左移
                {
                    --right;
                    if(-error < min)
                    {
                        min = -error;
                        result = threeSum;
                    }
                }
            }
        }
        return result;
    }
}