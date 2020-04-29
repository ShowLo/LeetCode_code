class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int L = N - k + 1;
        if (L <= 0) {
            return new int[0];
        }
        int[] result = new int[L];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < N; ++i) {
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
