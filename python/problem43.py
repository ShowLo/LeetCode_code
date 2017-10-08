class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if len(num1) == 0 or len(num2) == 0 or num1 == '0' or num2 == '0':
            return '0'
        result = []
        for i in range(len(num1) - 1, -1, -1):
            carry = 0
            pos = len(num1) - 1 - i
            for j in range(len(num2) - 1, -1, -1):
                temp = int(num1[i]) * int(num2[j]) + carry
                if pos < len(result):
                    temp += int(result[pos])
                    result[pos] = str(temp % 10)
                else:
                    result.append(str(temp % 10))
                carry = temp // 10
                pos += 1
            if carry > 0:
                result.append(str(carry))
        return ''.join(result[::-1])    