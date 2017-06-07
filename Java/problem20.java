public class Solution
{
    public boolean isValid(String s)
    {
        HashMap<Character, Character> match = new HashMap<Character, Character>();
        match.put(')', '(');
        match.put('}', '{');
        match.put(']', '[');
        int length = s.length();
        if(length == 0)
            return true;
        if(length % 2 == 1)                     //奇数个必不匹配
            return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < length; ++i)
        {
            if(match.containsKey(s.charAt(i)))  //是右符号的情况
            {
                //栈已经空或栈顶元素不匹配的情况下必匹配失败
                if(stack.empty() || stack.pop() != match.get(s.charAt(i)))
                    return false;
            }
            else                                //左符号的情况下直接入栈
                stack.push(s.charAt(i));
        }
        return stack.empty();                   //当最后栈空的话说明匹配成功
    }
}