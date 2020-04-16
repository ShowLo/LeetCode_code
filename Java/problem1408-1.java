class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
