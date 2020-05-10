class Solution:
    def isNumber(self, s: str) -> bool:
        def isDigits(num, prev):
            if len(num) == 0:
                return False
            if num[0] == '+' or num[0] == '-':
                return isDigits(num[1:], prev)
            if len(num) == 1 and not (num >= '0' and num <= '9'):
                return False
            findPoint = prev == False
            for n in num:
                if n == '.':
                    if findPoint:
                        return False
                    findPoint = True
                elif not (n >= '0' and n <= '9'):
                    return False
            return True

        strs = s.strip().split('e')
        if len(strs) > 2 or len(strs) == 0:
            return False
        if len(strs) == 1:
            return isDigits(strs[0], True)
        else:
            return isDigits(strs[0], True) and isDigits(strs[1], False)
