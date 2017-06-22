public class Solution
{
    public int longestValidParentheses(String s)
    {
        int sLen = s.length();
        int[] validLen = new int[sLen];
        for(int i = 0; i < sLen; ++i)
            validLen[i] = 0;
        
        if(sLen == 0)
            return 0;
        
        int maxLen = 0;
        for(int i = sLen - 2; i >=0 ; --i)
        {
            if(s.charAt(i) == '(')
            {
                int nextMacthPosition = i + validLen[i + 1] + 1;                    //与当前符号可能匹配的符号位置
                if(nextMacthPosition < sLen && s.charAt(nextMacthPosition) == ')')  //这个位置没越界且匹配
                {
                    validLen[i] = validLen[i + 1] + 2;                              //更新匹配长度
                    if(nextMacthPosition + 1 < sLen)
                        validLen[i] += validLen[nextMacthPosition + 1];
                    maxLen = validLen[i] > maxLen ? validLen[i] : maxLen;
                }
            }
        }
                
        return maxLen;
    }
}