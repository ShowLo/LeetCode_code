class CQueue {
    private Stack<Integer> stack_in;
    private Stack<Integer> stack_out;

    public CQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack_in.push(value);
    }
    
    public int deleteHead() {
        if (stack_in.isEmpty() && stack_out.isEmpty()) {
            return -1;
        }
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
