public class Solution
{
    public int divide(int dividend, int divisor)
	{
		int signal = 1;
		long dividendLong = (long)dividend;
		long divisorLong = (long)divisor;
		if((dividendLong < 0) ^ (divisorLong < 0))          //仅当除数、被除数之一为负数时结果才需变号
			signal = -1;
		if(dividendLong < 0)                                //将除数和被除数都先变为正数
			dividendLong = ~dividendLong + 1;
		if(divisorLong < 0)
			divisorLong = ~divisorLong + 1;

		if(divisorLong > dividendLong || dividendLong == 0) //被除数小于除数或者被除数为零
			return 0;

		long result = 0;
		long quotient = 1;
		long multidivisorLong = divisorLong;
		long error = dividendLong - multidivisorLong;
		boolean flag = false;
		if(error == 0)                                      //被除数和除数相等
		{
			if(signal == -1)
				return -1;
			else
				return 1;
		}
		while(error >= 0)
		{
			if(error >= multidivisorLong)                   //只要被除数还为除数和商的积的2倍以上
			{
				quotient <<= 1;                             //商乘以2
				multidivisorLong <<= 1;                     //除数和商的积也乘以2
				flag = true;                                //置标志，表明累加商未完成
			}
			else                                            //如果被除数不够除数和商的2倍
			{
				result += quotient;                         //累加商
				dividendLong -= multidivisorLong;           //更新被除数
				multidivisorLong = divisorLong;             //更新除数和商的积
				quotient = 1;                               //更新商
				flag = false;                               //消除标志，表明累加商已完成
			}
			error = dividendLong - multidivisorLong;
		}
		if(flag)
			result += quotient;                             //标志还在的情况下需累加商

		if(signal == -1)                                    //恢复符号位
			result = ~result + 1;
		if(result > Integer.MAX_VALUE)                      //判断是否溢出
			return Integer.MAX_VALUE;
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}
}