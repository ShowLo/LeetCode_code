class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        match = {')':'(','}':'{',']':'['};
        length = len(s);
        if length == 0:
            return True;
        if length % 2 == 1:                 #奇数个必不匹配
            return False;
        stack = [];
        for i in range(length):
                                            #当栈已空或为左符号或与栈顶符号不匹配时，入栈
            if len(stack) == 0 or s[i] not in match or stack[-1] != match[s[i]]:
                stack.append(s[i]);
            else:
                stack.pop();
        return len(stack) == 0;             #当最后栈空的话说明匹配成功