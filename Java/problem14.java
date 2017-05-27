public class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        int len = strs.length;
        if(len == 0)
            return "";
        if(len == 1)
            return strs[0];
        boolean flag = true;
        int maxLen = 0;
        for(int i = 0; i < len; ++i)                //如果有任何一个字符串为空，直接返回空字符串
        {
            if(strs[i].length() == 0)
                return "";
        }
        char str;
        while(flag)
        {
            for(int i = 0; i < len; ++i)            //遍历list
            {
				str = strs[0].charAt(maxLen);
				if(strs[i].charAt(maxLen) != str)	//如果有对应位置的字符不一样了，退出循环
				{
				    flag = false;
				    break;
				}
				else						        //对应位置的字符目前是一样的
				{							        //如果目前的maxLen已经是某个字符串的长度了,进行内层循环之后就退出
					if(strs[i].length() == maxLen + 1)
					    flag = false;
					if(i == len - 1)		        //如果这已经是list的最后一个字符
					    ++maxLen;
				}
            }
        }
        return strs[0].substring(0, maxLen);
    }
}