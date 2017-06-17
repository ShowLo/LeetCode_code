public class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        //使用Boyer-Moore算法
        int lenHaystack = haystack.length();
        int lenNeedle = needle.length();
        if(lenNeedle == 0)
            return 0;
        int i = lenNeedle - 1, j = lenNeedle - 1;
        HashMap<Character, Integer> last = last_occur(needle);  //预处理获得各个字母在模式串中最后出现位置
        while(i < lenHaystack)
        {
            if(needle.charAt(j) == haystack.charAt(i))
            {
                if(j == 0)                      //匹配成功
                    return i;
                else                            //只是部分匹配成功，比较前一个字符
                {
                    --j;
                    --i;
                }
            }
            else                                //暂时失配，取下一个比较位置
            {
                i += lenNeedle - Math.min(j, last.get(haystack.charAt(i)) + 1);
                j = lenNeedle - 1;
            }
        }
        return -1;
    }
    private HashMap<Character, Integer> last_occur(String needle)
    {
        HashMap <Character, Integer> last = new HashMap<Character, Integer>();
        for(int i = 0; i < 26; ++i)
            last.put((char)('a' + i), -1);
        for(int i = 0; i < needle.length(); ++i)
            last.put(needle.charAt(i), i);
        return last;
    }
}