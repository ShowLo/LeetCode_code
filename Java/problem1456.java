class Solution {
    public int maxVowels(String s, int k) {
        int[] index = new int[26];
        Arrays.fill(index, -1);
        index['a' - 'a'] = 0;
        index['e' - 'a'] = 1;
        index['i' - 'a'] = 2;
        index['o' - 'a'] = 3;
        index['u' - 'a'] = 4;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int sum = 0;
        for (; right < k; ++right) {
            int idx = index[chars[right] - 'a'];
            if (idx!= -1) {
                ++sum;
            }
        }
        int result = sum;
        for (; right < chars.length; ++right) {
            int leftIdx = index[chars[left] - 'a'];
            int rightIdx = index[chars[right] - 'a'];
            
            if (leftIdx != -1 && rightIdx == -1) {
                --sum;
            }
            else if (rightIdx != -1 && leftIdx == -1) {
                ++sum;
                result = Math.max(result, sum);
            }
            ++left;
        }
        return result;
    }
}
