class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        d, origin = {}, {}
        for tt in t:
            d[tt] = 0                   #用来记录s中一个窗口内t中字符出现次数
            if tt in origin: 
                origin[tt] += 1         #记录t中各个字符原始出现次数
            else:
                origin[tt] = 1
        sLen, tLen = len(s), len(t)
        minLen = sLen + 1
        if tLen > sLen:
            return ''
        left, right = 0, 0
        count = 0
        result = ''
        while right < sLen:
            if s[right] in d.keys():                #当前窗口最右字符在t中
                if d[s[right]] < origin[s[right]]:  #如果当前窗口内此字符出现次数尚未达到原始出现次数
                    count += 1                      #那么窗口中所有字符出现总数加一
                d[s[right]] += 1
                if count == tLen:                   #如果总数已经达到了t串的长度，说明有一个符合条件的子串出现了
                    while True:                     #但是还需要移动左窗使得子串尽可能短
                        if s[left] in d.keys():     #如果左窗字符在t中的话
                                                    #如果出现次数超过原始出现次数，可以直接向右移动左窗
                            if d[s[left]] > origin[s[left]]:
                                d[s[left]] -= 1
                                left += 1
                            else:                   #否则说明已经尽可能短了
                                if minLen > right - left + 1:
                                    minLen = right - left + 1
                                    result = s[left : right + 1]
                                break
                        else:                       #如果左窗字符不在t中，直接右移左窗
                            left += 1
            right += 1                              #每次都要右移右窗
        return result