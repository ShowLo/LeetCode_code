class MedianFinder {
    private Queue<Integer> leftHeap;
    private Queue<Integer> rightHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 左边是一个大顶堆，令其保存的数的数量总是比右边多一个或相等
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 右边是一个小顶堆
        rightHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int leftSize = leftHeap.size();
        int rightSize = rightHeap.size();
        if (leftSize == rightSize) {
            if (leftSize == 0 || num < rightHeap.peek()) {
                // 都为空，或者当前数比右边所有数都小，加到左边
                leftHeap.offer(num);
            }
            else {
                // 为了把这个数加到右边，需要先把右边最小的那个给先弄到左边去
                leftHeap.offer(rightHeap.poll());
                rightHeap.offer(num);
            }
        }
        else {
            // 左边的数比右边的多一个
            if (num > leftHeap.peek()) {
                rightHeap.offer(num);
            }
            else {
                // 为了把这个数加到左边，需要先把左边最大的那个给先弄到右边去
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            }
        }
        /*if (rightHeap.size() == 0 || (num > rightHeap.peek())) {
            rightHeap.offer(num);
        }
        else {
            leftHeap.offer(num);
        }
        if (leftHeap.size() > rightHeap.size()) {
            rightHeap.offer(leftHeap.poll());
        }
        else if (rightHeap.size() - 1 > leftHeap.size()) {
            leftHeap.offer(rightHeap.poll());
        }*/
    }
    
    public double findMedian() {
        return (leftHeap.size() + rightHeap.size()) % 2 == 0 ? (leftHeap.peek() + rightHeap.peek()) / 2.0 : leftHeap.peek() * 1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
