public class Solution
{
    public List<String> letterCombinations(String digits) 
    {
        /*
        把问题构建成一颗多叉树
        一个节点的父节点对应的是其前面一个数字对应的那些字母
        一个节点的子节点对应的是其后面一个数字对应的那些字母
        比如'23'就可以构造成多叉树
                  a              b              c
                / | \          / | \          / | \
               d  e  f        d  e  f        d  e  f
        说明一个概念--“节点的重复周期”，比如第一层节点（即abc）的重复周期就为9，这里实际就没有重复
        第二层节点的重复周期为3，也就是在第二层每隔3个节点就会重复一次
        */
        //字典--键为数字，值为数字所对应的多个字母
        HashMap<Character, char[]> digit2letter = new HashMap<Character, char[]>();
        digit2letter.put('2', new char[]{'a', 'b', 'c'});
        digit2letter.put('3', new char[]{'d', 'e', 'f'});
        digit2letter.put('4', new char[]{'g', 'h', 'i'});
        digit2letter.put('5', new char[]{'j', 'k', 'l'});
        digit2letter.put('6', new char[]{'m', 'n', 'o'});
        digit2letter.put('7', new char[]{'p', 'q', 'r', 's'});
        digit2letter.put('8', new char[]{'t', 'u', 'v'});
        digit2letter.put('9', new char[]{'w', 'x', 'y', 'z'});
        //字典--键为数字，值为数字所对应的字母个数
        HashMap<Character, Integer> letterNum = new HashMap<Character, Integer>();
        letterNum.put('2', 3);
        letterNum.put('3', 3);
        letterNum.put('4', 3);
        letterNum.put('5', 3);
        letterNum.put('6', 3);
        letterNum.put('7', 4);
        letterNum.put('8', 3);
        letterNum.put('9', 4);
        
        int length = digits.length();
        List<String> result = new LinkedList<String>();
        int loopLen = 1;
        if(length == 0)
            return result;
        for(int i = 0; i < length; ++i)
            //先统计最上面那层节点的重复周期
            loopLen *= letterNum.get(digits.charAt(i));
        
        int resultLen = loopLen;                                    //结果的长度也就是最上一层节点的重复周期
        char[] firstLetter = digit2letter.get(digits.charAt(0));    //最上面那层节点的字母
        int totalNum = loopLen / letterNum.get(digits.charAt(0));   //每个字母重复次数为其最终叶子节点个数
        for(int i = 0; i < letterNum.get(digits.charAt(0)); ++i)    //先将最上面那层节点的字母加入
        {
            for(int j = 0; j < totalNum; ++j)
                result.add(Character.toString(firstLetter[i]));
        }
        
        int index;
        loopLen /= letterNum.get(digits.charAt(0));                 //进入下一层，更新所在层节点的重复周期
        for(int i = 1; i < length; ++i)
        {
            for(int j = 0; j < resultLen; ++j)
            {   //先对重复周期取模得到当前位置位于第一个周期的哪个位置，再除以下一层的重复周期，得到应加入的字母在字典中对应的索引
                index = (j % loopLen) / (loopLen / letterNum.get(digits.charAt(i)));
                result.set(j, result.get(j) + digit2letter.get(digits.charAt(i))[index]);
            }
            loopLen /= letterNum.get(digits.charAt(i));             //进入下一层，更新所在层节点的重复周期
        }
        return result;
    }
}