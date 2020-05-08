class Solution {
    private String toStr(int[] idx) {
        StringBuilder sb = new StringBuilder();
        for (int i : idx) {
            sb.append(String.valueOf(i) + "-");
        }
        return sb.toString();
    }
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        // 小顶堆
        PriorityQueue<SumAndIndex> heap = new PriorityQueue<>(
            new Comparator<SumAndIndex> () {
                @Override
                public int compare(SumAndIndex s1, SumAndIndex s2) {
                    return s1.curSum - s2.curSum;
                }
            }
        );
        int curSum = 0;
        for (int i = 0; i < m; ++i) {
            curSum += mat[i][0];
        }
        int[] index = new int[m];
        SumAndIndex item = new SumAndIndex(curSum, index);
        heap.offer(item);
        Set<String> set = new HashSet<>();
        set.add(toStr(index));
        for (int count = 0; count < k - 1; ++count) {
            item = heap.poll();
            index = item.indexs;
            for (int i = 0; i < m; ++i) {
                if (index[i] < n - 1) {
                    int[] newIdx = index.clone();
                    ++newIdx[i];
                    if (set.add(toStr(newIdx))) {
                        int newSum = item.curSum - mat[i][index[i]] + mat[i][newIdx[i]];
                        SumAndIndex newItem = new SumAndIndex(newSum, newIdx);
                        heap.offer(newItem);
                    }
                }
            }
        }
        item = heap.poll();
        return item.curSum;
    }
}

class SumAndIndex {
    int curSum;
    int[] indexs;
    public SumAndIndex(int s, int[] i) {
        curSum = s;
        indexs = i;
    }
}
