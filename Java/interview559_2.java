class MaxQueue {
    private Deque<Integer> originalQueue;
    private Deque<Integer> maxValueDeque;

    public MaxQueue() {
        originalQueue = new LinkedList<Integer>();
        maxValueDeque = new LinkedList<Integer>();
    }
    
    public int max_value() {
        if (maxValueDeque.size() > 0) {
            return maxValueDeque.peekFirst();
        }
        else {
            return -1;
        }
    }
    
    public void push_back(int value) {
        originalQueue.offerLast(value);
        while (maxValueDeque.size() > 0 && maxValueDeque.peekLast() < value) {
            maxValueDeque.pollLast();
        }
        maxValueDeque.offerLast(value);
    }
    
    public int pop_front() {
        if (originalQueue.size() == 0) {
            return -1;
        }
        int temp = originalQueue.pollFirst();
        if (temp == maxValueDeque.peekFirst()) {
            maxValueDeque.pollFirst();
        }
        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
