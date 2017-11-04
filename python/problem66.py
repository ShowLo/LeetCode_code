class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        num = len(digits)
        temp = 0
        for i in range(num - 1, -1, -1):
            temp = digits[i] + 1
            if temp < 10:
                digits[i] = temp
                return digits
            else:
                digits[i] = temp % 10
        if temp >= 10:
            digits.insert(0, 1)
        return digits