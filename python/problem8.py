class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        substr = re.split(r'\s*',str);                      #先以空格为分隔符分隔开字符串
        result = 0;
        if len(substr) == 1 and substr[0] == '':            #字符串为空
            return 0;
        if substr[0] == '':                                 #第一个字符就是空格
            if substr[1][0] == '+' or substr[1][0] == '-':  #存在正负号
                num = re.split(r'[a-zA-Z]',substr[1][1:]);  #取出紧跟在正负号后可能的数字，以英文字符分隔开
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;                               #非法字符直接返回0
                result = int(num[0]);                       #合法字符获得相应数
                if substr[1][0] == '-':
                    result = -result;
            else:                                           #没有正负号
                num = re.split(r'[a-zA-Z]',substr[1]);		
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;
                result = int(num[0]);
        else:                                               #第一个字符不是空格
            if substr[0][0] == '+' or substr[0][0] == '-':
                num = re.split(r'[a-zA-Z]',substr[0][1:]);
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;
                result = int(num[0]);
                if substr[0][0] == '-':
                    result = -result;
            else:
                num = re.split(r'[a-zA-Z]',substr[0]);
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;
                result = int(num[0]);
        if result > 2**31 - 1:                              #处理越界情况
            result = 2**31 - 1;
        elif result <= -2**31:
            result = -2**31;
        return result;
