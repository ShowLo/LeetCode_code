class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n/2] + nums2[n/2 - 1]) / 2.0 : nums2[n/2];
        }
        if (n == 0) {
            return m % 2 == 0 ? (nums1[m/2] + nums1[m/2 - 1]) / 2.0 : nums1[m/2];
        }
        int idx1 = 0, idx2 = 0;
        int count = 0;
        int middle = 0;
        while (count * 2 < m + n) {
            if (idx2 >= n || (idx1 < m && nums1[idx1] < nums2[idx2])) {
                middle = nums1[idx1++];       
            }
            else {
                middle = nums2[idx2++];
            }
            ++count;
        }
        if ((m + n) % 2 == 1) {
            return middle * 1.0;
        }
        else {
            int temp = (idx2 >= n || (idx1 < m && nums1[idx1] < nums2[idx2])) ? nums1[idx1] : nums2[idx2];
            return (middle + temp) / 2.0;
        }
    }
}
