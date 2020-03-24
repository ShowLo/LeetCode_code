class CustomStack {
    
    private int[] stack;
    private int[] inc;
    private int length;
    private int maxSize;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
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
            --length;
            int result = stack[length] + inc[length];
            if (length - 1 >= 0) {
                inc[length - 1] += inc[length];
            }
            inc[length] = 0;
            return result;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        k = k > length ? length : k;
        if (k > 0) {
            inc[k - 1] += val;
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
