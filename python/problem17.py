class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        '''
        把问题构建成一颗多叉树
        一个节点的父节点对应的是其前面一个数字对应的那些字母
        一个节点的子节点对应的是其后面一个数字对应的那些字母
        比如'23'就可以构造成多叉树
                  a              b              c
                / | \          / | \          / | \
               d  e  f        d  e  f        d  e  f
        说明一个概念--“节点的重复周期”，比如第一层节点（即abc）的重复周期就为9，这里实际就没有重复
        第二层节点的重复周期为3，也就是在第二层每隔3个节点就会重复一次
        '''
        digit2letter = {'2':['a','b','c'],'3':['d','e','f'],'4':['g','h','i'],'5':['j','k','l'],'6':['m','n','o'],'7':['p','q','r','s'],'8':['t','u','v'],'9':['w','x','y','z']};                          #字典--键为数字，值为数字所对应的多个字母
        letterNum = {'2':3,'3':3,'4':3,'5':3,'6':3,'7':4,'8':3,'9':4};      #字典--键为数字，值为数字所对应的字母个数
        length = len(digits);
        result = [];
        loopLen = 1;
        if length == 0:
            return result;
        for i in range(length):                                             #先统计最上面那层节点的重复周期
            loopLen *= letterNum[digits[i]];
        resultLen = loopLen;                                                #结果的长度也就是最上一层节点的重复周期
        firstLetter = digit2letter[digits[0]];                              #最上面那层节点的字母
        for i in range(letterNum[digits[0]]):                               #先将最上面那层节点的字母加入
            result += [firstLetter[i]] * (loopLen // letterNum[digits[0]]); #每个字母重复次数为其最终叶子节点个数
        loopLen //= letterNum[digits[0]];                                   #进入下一层，更新所在层节点的重复周期
        for i in range(1,length):
            for j in range(resultLen):
                #先对重复周期取模得到当前位置位于第一个周期的哪个位置，再除以下一层的重复周期，得到应加入的字母在字典中对应的索引
                index = (j % loopLen) // (loopLen // letterNum[digits[i]]);
                result[j] += digit2letter[digits[i]][index];
            loopLen //= letterNum[digits[i]];                               #进入下一层，更新所在层节点的重复周期
        return result;