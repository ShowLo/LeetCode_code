class Solution {
    private List<String> result;

    private void generate(char[] str, int idx, int n, int leftNum, int stackLen) {
        if (stackLen == 0) {
            // 栈空的情况下只能加左括号了
            str[idx] = '(';
            generate(str, idx + 1, n, leftNum + 1, 1);
        }
        else {
            if (leftNum == n) {
                // 左括号数满了，把右括号都给加上去
                for (int i = 0; i < stackLen; ++i) {
                    str[idx + i] = ')';
                }
                result.add(new String(str));
            }
            else {
                // 还可以加左括号或右括号
                str[idx] = '(';
                generate(str, idx + 1, n, leftNum + 1, stackLen + 1);
                str[idx] = ')';
                generate(str, idx + 1, n, leftNum, stackLen - 1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        generate(new char[n * 2], 0, n, 0, 0);
        return result;
    }
}
