public class Solution
{
    public int romanToInt(String s) 
    {
        HashMap<Character, Integer> romanInt = new HashMap<Character, Integer>();
        romanInt.put('I', 1);
        romanInt.put('V', 5);
        romanInt.put('X',10);
        romanInt.put('L',50);
        romanInt.put('C',100);
        romanInt.put('D',500);
        romanInt.put('M',1000);             //各罗马数字所对应阿拉伯数字
        int num = romanInt.get(s.charAt(0));
        for(int i = 1; i < s.length(); ++i) //根据罗马数字和阿拉伯数字对应关系进行转换
        {
            if(romanInt.get(s.charAt(i)) > romanInt.get(s.charAt(i - 1)))
                num += romanInt.get(s.charAt(i)) - 2 * romanInt.get(s.charAt(i - 1));
            else
                num += romanInt.get(s.charAt(i));
        }
        return num;

    }
}