class Solution(object):
    def recursionParenthesis(self,left,right,s,strList):
        if left > right:                #未加进去的左括号如果比右括号还多，肯定最终不能匹配
            return;
        elif left == 0 and right == 0:  #左括号和右括号已经全部加进去了，匹配成功
            strList.append(s);
        else:
            if left > 0:                #还有未加进去的左括号，加进去一个
                self.recursionParenthesis(left - 1,right,s + '(',strList);
            if right > 0:               #还有未加进去的右括号，加进去一个
                self.recursionParenthesis(left,right - 1,s + ')',strList);
    
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        strList = [];
        s = '';
        self.recursionParenthesis(n,n,s,strList);
        return strList;