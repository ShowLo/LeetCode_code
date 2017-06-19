public class Solution 
{
    public List<Integer> findSubstring(String s, String[] words) 
    {
        LinkedList<Integer> result = new LinkedList<Integer>();
        HashMap<String, Integer> wordDict = new HashMap<String, Integer>();
        HashMap<String, Integer> matchNum = new HashMap<String, Integer>();
        for(String word : words)
        {
            wordDict.put(word, 0);
            matchNum.put(word, 0);
        }
        for(String word : words)                                                //记录每个单词出现次数
            matchNum.put(word, matchNum.get(word) + 1);
        int wordLen = words[0].length();
        int wordNum = words.length;
        String substr;
        for(int i = 0; i < s.length() - wordLen * wordNum + 1; ++i)
        {
            for(int j = 1; j < wordNum + 1; ++j)
            {
                substr = s.substring(i + (j - 1) * wordLen, i + j * wordLen);   //在字符串中切出一个跟单词一样长度的子串
                //如果单词存在于字典中且出现次数为零
                if(wordDict.containsKey(substr) && wordDict.get(substr) < matchNum.get(substr))
                {
                    wordDict.put(substr,  wordDict.get(substr) + 1);            //出现次数加一                                
                    if(j == wordNum)                                            //匹配成功    
                        result.add(i);
                }
                else
                    break;
            }
            for(String word : words)
            {
                wordDict.put(word, 0);                                          //出现次数清零
            }
        }
        return result;
    }
}