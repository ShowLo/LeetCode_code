class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue mink = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for (int i = 0; i < k; ++i) {
            mink.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (arr[i] < (int)mink.peek()) {
                mink.poll();
                mink.offer(arr[i]);
            }
        }
        int[] result = new int[k];
        Iterator iter = mink.iterator();
        int i = 0;
        while (iter.hasNext()) {
            result[i++] = (int)iter.next();
        }
        return result;
    }
}
