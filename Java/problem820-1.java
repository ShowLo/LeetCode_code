class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        List<String> SList = new LinkedList<>();
        int result = 0;
        for (String s : words) {
            boolean isEnd = false;
            for (String longerStr : SList) {
                if (longerStr.endsWith(s)) {
                    isEnd = true;
                    break;
                }
            }
            if (!isEnd) {
                result += s.length() + 1;
                SList.add(s);
            }
        }
        return result;
    }
}
