class CustomStack {
    
    private int[] stack;
    private int length;
    private int maxSize;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        length = 0;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (length < this.maxSize) {
            stack[length++] = x;
        }
    }
    
    public int pop() {
        if (length > 0) {
            return stack[--length];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        k = k > length ? length : k;
        for (int i = 0; i < k; ++i) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
