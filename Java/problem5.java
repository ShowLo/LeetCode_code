public class Solution {
    public String longestPalindrome(String s) 
    {
        //using Manacher Algorithm
        int length = s.length();
        if(length == 1)                         //如果是单字符的话本身就是回文串了
            return s;
        
        int newLen = length * 2 + 1;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < newLen; ++i)         //将诸如abc的字符串变为#a#b#c#
        {
            if(i % 2 == 0)
                str.append("#");
            else
                str.append(s.charAt((i - 1)/2));
        }
                
        int[] L = new int[newLen];
        for(int i = 0; i < newLen; ++i)         //初始化
        {
            L[i] = 1;
        }
        L[1] = 2;
        
        int maxID = 1, maxRight = 3;
        int i,j,d;
        int maxIndex = 1, maxLen = 1;
        for(i = 2; i< newLen - 1; ++i)
        {
            if(L[maxID] > 1 && i < maxRight)    //当前位置处于已有最右回文串范围之内
            {
                j = 2 * maxID - i;              //i关于已有最右回文串中心的对称点j
                d = maxRight - i - L[j];        
                if(d == 0)                      //以j为中心的回文串的范围刚好不超过最右回文串的范围
                {
                    L[i] = L[j];                //此时以i为中心的回文串的范围先置为以j为中心的一样
                    while(i + L[i] < newLen && i - L[i] >= 0 && str.charAt(i + L[i]) == str.charAt(i - L[i]))
                        ++L[i];                 //然后再拓展以i为中心的回文串
                    if(i + L[i] >= maxRight)    //如果以i为中心的回文串长度更长的话，更新最右回文串中心位置以及最右位置
                    {
                        maxID = i;
                        maxRight = i + L[i];
                        if(L[i] > maxLen)       //更新最长回文子串位置及长度
                        {
                            maxLen = L[i];
                            maxIndex = i;
                        }
                    }
                }
                else                            //在d<0的情况下以i为中心的回文串范围只能和以j为中心的范围一致
                                                //在d>0的情况下以i为中心的回文串范围只能到达最右回文串的最右边
                    L[i] = L[j] < maxRight - i ? L[j] : maxRight - i;
            }
            else                                //当前位置超出了最右回文串范围
            {
                while(i + L[i] < newLen && i - L[i] >= 0 && str.charAt(i + L[i]) == str.charAt(i - L[i]))
                    ++L[i];                     //在不越界的情况下拓展以i为中心的回文串
                if(i + L[i] >= maxRight)        //如果以i为中心的回文串长度更长的话，更新最右回文串中心位置以及最右位置
                {
                    maxID = i;
                    maxRight = i + L[i];
                    if(L[i] > maxLen)           //更新最长回文串位置及长度
                    {
                        maxLen = L[i];
                        maxIndex = i;
                    }
                }
            }
        }
        if(maxIndex % 2 == 0)                   //偶数的话说明是以‘#’为中心，这样最大回文串有偶数个字符
            return s.substring(maxIndex/2 - (maxLen-1)/2, maxIndex/2 + (maxLen-1)/2);
        else                                    //奇数的话说明是以字符为中心，这样最大回文串有奇数个字符
            return s.substring((maxIndex-1)/2 - maxLen/2 + 1, (maxIndex-1)/2 + maxLen/2);
    }
}