public class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int lenS = s.length();
        int maxLen = 0;
        int left = 0, right = 0, position = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(right < lenS)
        {
            if(map.containsKey(s.charAt(right)))                //出现重复的字符且这个字符在窗口中
            {
                position = map.get(s.charAt(right));
                if(left <= position)
                    left = position + 1;                        //左窗口位置调整到这个重复字符的右端
            }
            else                                                //没有重复字符出现
                maxLen = maxLen > right - left + 1 ? maxLen : right - left + 1;      //更新最长长度
            map.put(s.charAt(right), right);                    //更新字符位置
            ++right;                                            //右窗口后移
        }
        return maxLen;
    }
}