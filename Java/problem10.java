public class Solution 
{
    public boolean isMatch(String s, String p) 
    {
        /*if(p.length() == 0)
            return s.length() == 0;
        if(p.length() > 1 && p.charAt(1) == '*')
            return isMatch(s,p.substring(2)) || ((s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) && isMatch(s.substring(1), p));
        else
            return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));*/
        
        int sLen = s.length();
        int pLen = p.length();
        if(pLen == 0)						        //当p为空时，只有s也为空才能匹配
            return sLen == 0;
        if(sLen == 0)						        //当s为空时,p的形式需为"a*b*c*"
        {
            if(pLen % 2 != 0)
                return false;
            for(int i = 1; i < pLen; i += 2)
            {
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if(sLen == 1 && pLen == 1)			        //s和p均为单字符时或者相同、或者p为'.'时才能匹配成功
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(sLen != 1 && pLen == 1)			        //p为单字符而s不是时，一定匹配失败
            return false;
        if(p.charAt(1) != '*')			            //第一种情况，不带*
        {
            //头个字符匹配成功的话，匹配是否成功取决于去掉头字符之后的字符串
            if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
        else								        //另一种情况，带*
		{									        //匹配0/1/2……个字符的情况
            while(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
            {
                if(isMatch(s,p.substring(2)))	    //看字符串与去掉头两个字符的模式串是否匹配，匹配的话整个就匹配了
                    return true;
                s = s.substring(1);					//匹配还没最终成功的情况下每次字符串都要先减掉一个匹配字符
            }
            return isMatch(s,p.substring(2));	    //还是没有匹配成功，那最终是否匹配就取决于去掉已匹配字符之后的字符串与模式串
		}
    }
}