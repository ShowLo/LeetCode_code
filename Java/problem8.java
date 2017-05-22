public class Solution
{
    public int myAtoi(String str) 
	{
	    int strLen = str.length();
	    if(strLen == 0)                                                         //空字符串
	        return 0;
	    int i = 0;
	    char signChar = '+', c;
	    while(i < strLen && (str.charAt(i) > '9' || str.charAt(i) < '0'))       //遍历直到出现数字
	    {
	        c = str.charAt(i);
	        if(c == '+' || c == '-')                                            //记录符号位
	        {
	            signChar = c;
	            ++i;
	            break;
	        }
	        else if(c != ' ')                                                   //在数字之前出现字母，非法
	            return 0;
	        ++i;
	    }
	    int sign = (signChar == '-' ? -1 : 1);
	    int cNum;
	    long result = 0;
	    int maxValue = Integer.MAX_VALUE, minValue = Integer.MIN_VALUE;
	    if(sign == 1)                                                           //符号位为正
	    {
	        while(i < strLen && str.charAt(i) >= '0' && str.charAt(i) <= '9')   //遍历数字
	        {
	            cNum = str.charAt(i) - 48;
	            result = result * 10 + cNum;
	            if(result > maxValue)                                           //判断溢出
	                return maxValue;
	            ++i;
	        }
	        return (int)result;
	    }
	    else
	    {
	        while(i < strLen && str.charAt(i) >= '0' && str.charAt(i) <= '9')
	        {
	            cNum = str.charAt(i) - 48;
	            result = result * 10 - cNum;
	            if(result < minValue)
	                return minValue;
	            ++i;
	        }
	        return (int)result;
	    }
	}
}