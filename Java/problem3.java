public class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int lenS = s.length();
        int maxLen = 0;
        int left = 0, right = 0, position = 0;
        char c;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(right < lenS)
        {
            c = s.charAt(right);
            if(map.containsKey(c) && left <= map.get(c))                        //出现重复的字符且这个字符在窗口中
            {
                left = map.get(c) + 1;                                          //左窗口位置调整到这个重复字符的右端
            }
            else                                                                //没有重复字符出现
                maxLen = maxLen > right - left + 1 ? maxLen : right - left + 1; //更新最长长度
            map.put(c, right);                                                  //更新字符位置
            ++right;                                                            //右窗口后移
        }
        return maxLen;
    }
}