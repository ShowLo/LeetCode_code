class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        num = (s.strip()).split('e')
        if len(num) > 2:
            return False
        for i in range(len(num)):
            if len(num[i]) == 0:
                return False
            if i == 0:
                if self.onlyNum(num[i]) == None:
                    return False
            if i == 1:
                if self.isInt(num[i]) == None:
                    return False
        return True
        
    def onlyNum(self, s):
        if s[0] == '+' or s[0] == '-':
            return re.match('^\d+\.{0,1}\d*$', s[1:]) or re.match('^\.\d+$', s[1:])
        return re.match('^\d+\.{0,1}\d*$', s) or re.match('^\.\d+$', s)
    
    def isInt(self, s):
        if s[0] == '+' or s[0] == '-':
            return re.match('^\d+$', s[1:])
        return re.match('^\d+$', s)