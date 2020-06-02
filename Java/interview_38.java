class Solution {
    private char[] chars;
    private List<String> result;

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    private void dfs(int idx) {
        if (idx == chars.length - 1) {
            result.add(new String(chars));
            return;
        }
        boolean[] visited = new boolean[26];
        visited[chars[idx] - 'a'] = true;
        dfs(idx + 1);
        for (int i = idx + 1; i < chars.length; ++i) {
            if (!visited[chars[i] - 'a']) {
                visited[chars[i] - 'a'] = true;
                swap(idx, i);
                dfs(idx + 1);
                // 回溯
                swap(idx, i);
            }
        }
    }
    public String[] permutation(String s) {
        chars = s.toCharArray();
        result = new LinkedList<>();
        dfs(0);
        return result.toArray(new String[0]);
    }
}
