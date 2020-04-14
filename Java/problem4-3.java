class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n/2 - 1] + nums2[n/2]) / 2.0 : nums2[n/2];
        }
        int middle = (m + n + 1) / 2;
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = iMin + (iMax - iMin) / 2;
            int j = middle - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                // nums1[i]太小了，需要增大i
                iMin = i + 1;
            }
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // nums1[i - 1]太大了，需要减小i
                iMax = i - 1;
            }
            else {
                // 找到合适的i,j或者i,j到了边界
                int middleNum, middleNum_1;
                if (i == 0) {
                    middleNum = nums2[j - 1];
                }
                else if (j == 0) {
                    middleNum = nums1[i - 1];
                }
                else {
                    middleNum = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return middleNum;
                }
                if (i == m) {
                    middleNum_1 = nums2[j];
                }
                else if (j == n) {
                    middleNum_1 = nums1[i];
                }
                else {
                    middleNum_1 = Math.min(nums1[i], nums2[j]);
                }
                return (middleNum + middleNum_1) / 2.0;
            }
        }
        return 0.0;
    }
}
