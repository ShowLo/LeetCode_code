class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int m = arr[(n - 1) / 2];
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (Math.abs(i1 - m) > Math.abs(i2- m) || (Math.abs(i1 - m) == Math.abs(i2 - m) && i1 > i2)) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.add(arr[i]);
        }
        for (int i = k; i < n; ++i) {
            int num = queue.peek();
            if (Math.abs(arr[i] - m) > Math.abs(num - m) || (Math.abs(arr[i] - m) == Math.abs(num - m) && arr[i] > num)) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll();
        }
        return result;
    }
}
