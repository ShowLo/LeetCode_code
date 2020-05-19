class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int p : pushed) {
            if (p == popped[popIdx]) {
                ++popIdx;
                while (stack.size() > 0 && stack.peek() == popped[popIdx]) {
                    stack.pop();
                    ++popIdx;
                }
            }
            else {
                stack.push(p);
            }
        }
        return stack.size() == 0;
    }
}
