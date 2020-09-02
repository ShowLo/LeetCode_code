class Solution {
    public String minInteger(String num, int k) {
        char[] nums = num.toCharArray();
        int n = nums.length;
        SegmentTree segmentTree = new SegmentTree(n);
        LinkedList[] position = new LinkedList[10];
        for (int i = 0; i < 10; ++i) {
            position[i] = new LinkedList<Integer>();
        }
        for (int i = n - 1; i >= 0; --i) {
            position[nums[i] - '0'].addLast(i);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int digit = nums[i] - '0';
            if (position[digit].size() == 0 || (int)(position[digit].getLast()) > i) {
                ++i;
                continue;
            }
            for (int j = 0; j <= digit; ++j) {
                if (position[j].size() == 0) {
                    continue;
                }
                int originIdx = (int)position[j].getLast();
                int count = originIdx - segmentTree.getSum(originIdx + 1);
                if (count <= k) {
                    k -= count;
                    sb.append(nums[originIdx]);
                    position[j].removeLast();
                    segmentTree.update(originIdx + 1, 1);
                    break;
                }
            }
        }
        return sb.toString();
    }
}

class SegmentTree {
    int n;
    int[] tree;

    public SegmentTree(int val) {
        n = val;
        tree = new int[val + 1];
    }

    public int lowbit(int x) {
        return x & (-x);
    }

    public void update(int idx, int x) {
        while (idx <= n) {
            tree[idx] += x;
            idx += lowbit(idx);
        }
    }

    public int getSum(int idx) {
        int res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= lowbit(idx);
        }
        return res;
    }
}
