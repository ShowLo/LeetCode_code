public class Solution
{
    public int reverse(int x) 
    {
        int temp = x;
        int r, result = 0, newResult = 0;
        while(temp != 0)
        {
            r = temp % 10;
            temp = temp / 10;
            newResult = result * 10 + r;
            if((newResult - r)/10 != result)        //溢出
                return 0;
            result = newResult;
        }
        return result;
    }
}