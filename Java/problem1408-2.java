class Solution {
    public List<String> stringMatching(String[] words) {
        StringBuilder all = new StringBuilder(3000);
        for (String word : words) {
            all.append(word + " ");
        }
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (all.indexOf(word) != all.lastIndexOf(word)) {
                result.add(word);
            }
        }
        return result;
    }
}
