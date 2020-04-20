class Solution {
    // 树状数组
    private int[] tree;

    private int lowbit(int x) {
        return x & (-x);
    }

    // 树状数组的更新操作，将idx位置上的数加上value
    private void update(int idx, int value) {
        while (idx < tree.length) {
            tree[idx] += value;
            idx += lowbit(idx);
        }
    }

    // 数组数组的区间查询，返回从1到idx区间的和
    private int getSum(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= lowbit(idx);
        }
        return sum;
    }

    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        // 用一个树状数组，数组从1-i的区间和getSum(i)代表在i前面有多少个数（包括自身）
        // 所以一个数对应到P中的真实索引就是getSum(i)-1
        tree = new int[n + m + 1];
        // P中的1-m这m个数到其在树状数组中索引的一个映射
        int[] value2index = new int[m + 1];
        for (int i = 1; i <= m; ++i) {
            // 初始化，把P中m个数先放到树状数组的后m个位置
            value2index[i] = n + i;
            update(n + i, 1);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int indexQuery = value2index[queries[i]];
            result[i] = getSum(indexQuery) - 1;
            // 把位置indexQuery上的数给移动到起始位置，当前位置的数删除，所以需要-1
            update(indexQuery, -1);
            // 放置这个被删除的数的起始位置
            value2index[queries[i]] = n - i;
            // 需要重新从起始位置开始更新树状数组
            update(n - i, 1);
        }
        return result;
    }
}
