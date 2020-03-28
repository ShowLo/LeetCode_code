class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        Set<String> set = new HashSet<>();
        int result = 0;
        for (String s : words) {
            if (!set.contains(s)) {
                result += s.length() + 1;
                for (int i = 0; i < s.length(); ++i) {
                    set.add(s.substring(i));
                }
            }
        }
        return result;
    }
}
