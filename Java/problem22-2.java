class Solution {
    private List<String> result;

    private void dfs(char[] str, int idx, int leftNum, int rightNum, int n) {
        if (idx == n * 2) {
            result.add(new String(str));
            return;
        }
        if (leftNum < n) {
            str[idx] = '(';
            dfs(str, idx + 1, leftNum + 1, rightNum, n);
        }
        // 右括号数小于左括号数的情况下才能加右括号
        if (rightNum < leftNum) {
            str[idx] = ')';
            dfs(str, idx + 1, leftNum, rightNum + 1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        dfs(new char[n * 2], 0, 0, 0, n);
        return result;
    }
}
