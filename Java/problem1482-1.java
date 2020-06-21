class Solution {
    private int flower(boolean[] bloom, int k) {
        int count = 0;
        int prevIdx = 0;
        boolean prevBloom = bloom[0];
        for (int i = 1; i < bloom.length; ++i) {
            if (bloom[i]) {
                if (!prevBloom) {
                    prevIdx = i;
                    prevBloom = true;
                }
            }
            else {
                if (prevBloom) {
                    count += (i - prevIdx) / k;
                    prevBloom = false;
                }
            }
        }
        if (prevBloom) {
            count += (bloom.length - prevIdx) / k;
        }
        return count;
    }
    
    private int moreFlower(boolean[] bloom, int k, int idx) {
        int count = 0;
        int left = 0, right = 0;
        if (idx == 0) {
            int i = 1;
            while (i < bloom.length && bloom[i]) {
                ++count;
                ++i;
            }
            right = count;
        }
        else if (idx == bloom.length - 1) {
            int i = idx - 1;
            while (i >= 0 && bloom[i]) {
                ++count;
                --i;
            }
            left = count;
        }
        else {
            int i = idx + 1;
            while (i < bloom.length && bloom[i]) {
                ++count;
                ++i;
            }
            right = count;
            count = 0;
            i = idx - 1;
            while (i >= 0 && bloom[i]) {
                ++count;
                --i;
            }
            left = count;
        }
        if (left == 0) {
            if ((right + 1) % k == 0) {
                return 1;
            }
            return 0;
        }
        else if (right == 0) {
            if ((left + 1) % k == 0) {
                return 1;
            }
            return 0;
        }
        else {
            return (left + right + 1) / k - left / k - right / k;
        }
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }
        DayAndIdx[] dai = new DayAndIdx[n];
        for (int i = 0; i < n; ++i) {
            dai[i] = new DayAndIdx(bloomDay[i], i);
        }
        Arrays.sort(dai, new Comparator<DayAndIdx>() {
            @Override
            public int compare(DayAndIdx d1, DayAndIdx d2) {
                return d1.day - d2.day;
            }
        });
        boolean[] bloom = new boolean[n];
        for (int i = 0; i < m * k; ++i) {
            bloom[dai[i].idx] = true;
        }
        int count = flower(bloom, k);
        if (count >= m) {
            return dai[m * k - 1].day;
        }
        for (int i = m * k; i < n; ++i) {
            bloom[dai[i].idx] = true;
            count += moreFlower(bloom, k, dai[i].idx);
            if (count >= m) {
                return dai[i].day;
            }
        }
        return -1;
    }
}

class DayAndIdx {
    int day;
    int idx;
    
    public DayAndIdx(int d, int i) {
        day = d;
        idx = i;
    }
}
