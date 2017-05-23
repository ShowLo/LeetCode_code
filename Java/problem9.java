public class Solution
{
    public boolean isPalindrome(int x)
    {
        if(x < 0 || (x % 10 == 0 && x != 0))    //负数以及10的整倍数的情况先排除
            return false;
        int low = 0;
        while(x > low)                          //高位的数大于低位反转的数的情况下一直进行
        {
            low = low * 10 + x % 10;            //低位的数反转过来
            x = x / 10;                         //高位的数不反转
        }
        return (x == low || x == low / 10);     //高位的数等于低位反转数或者其去掉最低位（即原来中间位）时是回文数
    }
}