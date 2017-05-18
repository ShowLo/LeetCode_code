public class Solution
{
    public String convert(String s, int numRows) 
    {
        if(numRows == 1)
            return s;
        StringBuilder result = new StringBuilder();
        StringBuilder[] temp = new StringBuilder[numRows];
        for(int i = 0; i < numRows; ++i)
            temp[i] = new StringBuilder();
        int t,index;
        for(int i = 0; i < s.length(); ++i)
        {
            t = i % (numRows * 2 - 2);
            index = numRows - 1 - abs(t - numRows + 1);
            temp[index].append(s.charAt(i));
        }
        for(int i = 0; i < numRows; ++i)
            result.append(temp[i]);
        return result.toString();
    }
    private int abs(int n)
    {
        return n > 0 ? n :-n;
    }
}