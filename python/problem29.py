class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        signal = 1;
        if (dividend < 0) ^ (divisor < 0):      #仅当除数、被除数之一为负数时结果才需变号
            signal = -1;
        if dividend < 0:                        #将除数和被除数都先变为正数
            dividend = ~dividend + 1;
        if divisor < 0:
            divisor = ~divisor + 1;

        if divisor > dividend or dividend == 0: #被除数小于除数或者被除数为零
            return 0;

        result, quotient = 0, 1;
        multiDivisor = divisor;
        error = dividend - multiDivisor;
        flag = False;
        if error == 0:                          #被除数和除数相等
            if signal == -1:
                return -1;
            else:
                return 1;
        while error >= 0:
            if error >= multiDivisor:           #只要被除数还为除数和商的积的2倍以上
                quotient <<= 1;                 #商乘以2
                multiDivisor <<= 1;             #除数和商的积也乘以2
                flag = True;                    #置标志，表明累加商未完成
            else:                               #如果被除数不够除数和商的2倍
                result += quotient;             #累加商
                dividend -= multiDivisor;       #更新被除数
                multiDivisor = divisor;         #更新除数和商的积
                quotient = 1;                   #更新商
                flag = False;                   #消除标志，表明累加商已完成
            error = dividend - multiDivisor;
        if flag:
            result += quotient;                 #标志还在的情况下需累加商

        if signal == -1:                        #恢复符号位
            result = ~result + 1;
        if result > 2 ** 31 - 1:                #判断是否溢出
            return 2 ** 31 - 1;
        if result < - 2 ** 31:
            return -2 ** 31;
        return result;