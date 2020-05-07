class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // 两个单调队列分别维护从left到right之间的最大值最小值
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int result = 0;
        int left = 0, right = 0;
        minDeque.offer(0);
        maxDeque.offer(0);
        while (right < nums.length) {
            int minIdx = minDeque.peekFirst();
            int maxIdx = maxDeque.peekFirst();
            if (nums[maxIdx] - nums[minIdx] <= limit) {
                // 最大值与最小值之差小于限制的情况下右指针右移
                result = Math.max(result, right - left + 1);
                ++right;
                // 维护两个单调队列
                while (right < nums.length && minDeque.size() > 0 && nums[right] < nums[minDeque.peekLast()]) {
                    minDeque.pollLast();
                }
                minDeque.offerLast(right);
                while (right < nums.length && maxDeque.size() > 0 && nums[right] > nums[maxDeque.peekLast()]) {
                    maxDeque.pollLast();
                }
                maxDeque.offerLast(right);
            }
            else {
                // 最大值与最小值之差大于限制的情况下左指针右移
                left = Math.min(minIdx, maxIdx) + 1;
                while (minDeque.size() > 0 && minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
                while (maxDeque.size() > 0 && maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
            }
        }
        return result;
    }
}
