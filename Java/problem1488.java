class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        Arrays.fill(result, -1);
        // 记录rains[i]-->i
        Map<Integer, Integer> pos = new HashMap<>();
        // 记录0的位置
        LinkedList<Integer> zeros = new LinkedList<>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] > 0) {
                // 这个湖之前出现过，所以需要抽水防止溢出
                if (pos.containsKey(rains[i])) {
                    int prev = pos.get(rains[i]);
                    // 没有可以抽水的日子了，直接返回
                    if (zeros.size() == 0 || zeros.getLast() < prev) {
                        return new int[0];
                    }
                    int day = -1;
                    // 找到第一个可以抽去第rains[i]个湖的水的日子
                    Iterator<Integer> iter = zeros.iterator();
                    while ((day = iter.next()) <= prev);
                    iter.remove();
                    result[day] = rains[i];
                }
                pos.put(rains[i], i);
            }
            else {
                zeros.add(i);
            }
        }
        // 剩下了为0的日子直接随便找个湖抽
        for (int idx : zeros) {
            result[idx] = 1;
        }
        return result;
    }
}
