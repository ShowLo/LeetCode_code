class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        aLen = len(a)
        bLen = len(b)
        carry = 0
        result = []
        for i in range(min(aLen, bLen)):
            aDigit = a[aLen - 1 - i]
            bDigit = b[bLen - 1 - i]
            tempSum = int(aDigit) + int(bDigit) + carry
            if tempSum > 1:
                result.append(str(tempSum % 2))
                carry = 1
            else:
                result.append(str(tempSum))
                carry = 0
        if aLen > bLen:
            for i in range(bLen, aLen):
                aDigit = a[aLen - 1 - i]
                tempSum = int(aDigit) + carry
                if tempSum > 1:
                    result.append('0')
                    carry = 1
                else:
                    result.append(str(tempSum))
                    carry = 0
        elif bLen > aLen:
            for i in range(aLen, bLen):
                bDigit = b[bLen - 1 - i]
                tempSum = int(bDigit) + carry
                if tempSum > 1:
                    result.append('0')
                    carry = 1
                else:
                    result.append(str(tempSum))
                    carry = 0
        if carry == 1:
            result.append('1')
            
        result.reverse()
        return ''.join(result)