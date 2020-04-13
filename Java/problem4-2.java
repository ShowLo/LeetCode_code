class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n/2] + nums2[n/2 - 1]) / 2.0 : nums2[n/2];
        }
        if (n == 0) {
            return m % 2 == 0 ? (nums1[m/2] + nums1[m/2 - 1]) / 2.0 : nums1[m/2];
        }
        int k = (m + n + 1) / 2;
        int idx1 = 0, idx2 = 0;
        int left1 = -1, left2 = -1;
        // 去掉k-1个数后idx1和idx2指向的两个数之中较小者就是第k小的数了
        while (k > 1) {
            idx1 = Math.min(m - 1, k / 2 + left1);
            idx2 = Math.min(n - 1, k - k / 2 + left2);
            if (nums1[idx1] < nums2[idx2]) {
                // nums1在idx1前面的所有数一定都比中位数小，全部去掉
                k -= idx1 - left1;
                if (idx1 == m - 1) {
                    return (m + n) % 2 == 0 ? (nums2[left2 + k] + nums2[left2 + k + 1]) / 2.0 : nums2[left2 + k];
                }
                left1 = idx1;
                if (k <= 1) {
                    idx1 = left1 + 1;
                }
            }
            else {
                // nums2在idx2前面的所有数一定都比中位数小，全部去掉
                k -= idx2 - left2;
                if (idx2 == n - 1) {
                    return (m + n) % 2 == 0 ? (nums1[left1 + k] + nums1[left1 + k + 1]) / 2.0 : nums1[left1 + k];
                }
                left2 = idx2;
                if (k <= 1) {
                    idx2 = left2 + 1;
                }
            }
        }
        if ((m + n) % 2 == 0) {
            // 偶数的情况下需要找到中间的两个数
            int n1, n2;
            if (nums1[idx1] < nums2[idx2]) {
                n1 = nums1[idx1];
                if (idx1 == m - 1) {
                    n2 = nums2[idx2];
                }
                else {
                    n2 = nums1[idx1 + 1] < nums2[idx2] ? nums1[idx1 + 1] : nums2[idx2];
                }
            }
            else {
                n1 = nums2[idx2];
                if (idx2 == n - 1) {
                    n2 = nums1[idx1];
                }
                else {
                    n2 = nums2[idx2 + 1] < nums1[idx1] ? nums2[idx2 + 1] : nums1[idx1];
                }
            }
            return (n1 + n2) / 2.0;
        }
        else {
            return nums1[idx1] < nums2[idx2] ? nums1[idx1] * 1.0 : nums2[idx2] * 1.0;
        }
    }
}
