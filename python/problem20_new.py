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
            if s[i] in match:               #是右符号的情况
                if len(stack) == 0:         #栈已经空，最终必匹配失败
                    return False;
                else:                       #栈顶元素不匹配的情况下最终也匹配失败
                    if stack.pop() != match[s[i]]:
                        return False;
            else:                           #左符号的情况下直接入栈
                stack.append(s[i]);
        return len(stack) == 0;             #当最后栈空的话说明匹配成功