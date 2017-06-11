public class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        LinkedList<String> strList = new LinkedList<String>();
        String s = "";
        recursionParenthesis(n, n, s, strList);
        return strList;
    }
    
    private void recursionParenthesis(int left, int right, String s, LinkedList strList)
    {
        if(left > right)                //未加进去的左括号如果比右括号还多，肯定最终不能匹配
            return;
        else if(left == 0 && right == 0)//左括号和右括号已经全部加进去了，匹配成功
            strList.add(s);
        else
        {
            if(left > 0)                //还有未加进去的左括号，加进去一个
                recursionParenthesis(left - 1,right,s + "(",strList);
            if(right > 0)               //还有未加进去的右括号，加进去一个
                recursionParenthesis(left,right - 1,s + ")",strList);
        }
    }
}