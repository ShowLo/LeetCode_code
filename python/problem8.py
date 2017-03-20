class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        substr = re.split(r'\s*',str);
        result = 0;
        if len(substr) == 1 and substr[0] == '':
            return 0;
        if substr[0] == '':
            if substr[1][0] == '+' or substr[1][0] == '-':
                num = re.split(r'[a-zA-Z]',substr[1][1:]);
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;
                result = int(num[0]);
                if substr[1][0] == '-':
                    result = -result;
            else:
                num = re.split(r'[a-zA-Z]',substr[1]);
                if num[0] == '' or num[0][0] > '9' or num[0][0] < '0':
                    return 0;
                result = int(num[0]);
        else:
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
        if result > 2**31 - 1:
            result = 2**31 - 1;
        elif result <= -2**31:
            result = -2**31;
        return result;