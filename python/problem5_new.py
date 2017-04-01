class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # using Manacher Algorithm
        length = len(s);
        if length == 1:                         #如果是单字符的话本身就是回文串了
            return s;
        newLen = length * 2 + 1;
        maxLen = 0;
        str = "";
        for i in range(newLen):                 #将诸如abc的字符串变为#a#b#c#
            if i % 2 == 0:
                str += "#";
            else:
                str += s[(i - 1) // 2];
        L = [1] * newLen;
        L[1] = 2;
        maxID = 1;
        maxRight = 3;
        for i in range(2, newLen - 1):
            if L[maxID] > 1 and i < maxRight:   #当前位置处于已有最右回文串范围之内
                j = 2 * maxID - i;              #i关于已有最右回文串中心的对称点j
                d = maxRight - i - L[j];        
                if d == 0:                      #以j为中心的回文串的范围刚好不超过最右回文串的范围
                    L[i] = L[j];                #此时以i为中心的回文串的范围先置为以j为中心的一样
                    while i + L[i] < newLen and i - L[i] >= 0 and str[i + L[i]] == str[i - L[i]]:
                        L[i] += 1;              #然后再拓展以i为中心的回文串
                    if i + L[i] >= maxRight:    #如果以i为中心的回文串长度更长的话，更新最右回文串中心位置以及最右位置
                        maxID = i;
                        maxRight = i + L[i];
                else:                           #在d<0的情况下以i为中心的回文串范围只能和以j为中心的范围一致
                                                #在d>0的情况下以i为中心的回文串范围只能到达最右回文串的最右边
                    L[i] = min(L[j], maxRight - i);
            else:                               #当前位置超出了最右回文串范围
                while i + L[i] < newLen and i - L[i] >= 0 and str[i + L[i]] == str[i - L[i]]:
                    L[i] += 1;                  #在不越界的情况下拓展以i为中心的回文串
                if i + L[i] >= maxRight:        #如果以i为中心的回文串长度更长的话，更新最右回文串中心位置以及最右位置
                    maxID = i;
                    maxRight = i + L[i];
        maxIndex = L.index(max(L));             #找到最大回文串的中心位置
        maxLen = L[maxIndex];
        if maxIndex % 2 == 0:                   #偶数的话说明是以‘#’为中心，这样最大回文串有偶数个字符
            return s[maxIndex // 2 - (maxLen - 1) // 2: maxIndex // 2 + (maxLen - 1) // 2];
        else:                                   #奇数的话说明是以字符为中心，这样最大回文串有奇数个字符
            return s[(maxIndex - 1) // 2 - maxLen // 2 + 1: (maxIndex - 1) // 2 + maxLen // 2];