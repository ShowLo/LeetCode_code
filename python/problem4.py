class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1 = len(nums1);
        len2 = len(nums2);
        if len1 == 0:
            if len2%2 == 0:
                return (nums2[len2/2 - 1] + nums2[len2/2])/2.;
            else:
                return nums2[len2//2];
        elif len2 == 0:
            if len1%2 == 0:
                return (nums1[len1/2 - 1] + nums1[len1/2])/2.;
            else:
                return nums1[len1//2];
        if len1 == 1 and len2 == 1:
            return (nums1[0] + nums2[0])/2.;
        length = len1 + len2;
        index1 = index2 = 0;
        nums = [];
        for i in range(length//2 + 1):
            if index1 < len1 and (index2 == len2 or nums1[index1] < nums2[index2]):
                nums.append(nums1[index1]);
                index1 = index1 + 1;
            else:
                nums.append(nums2[index2]);
                index2 = index2 + 1;
        if length % 2 == 0:
            return (nums[-1] + nums[-2])/2.;
        else:
            return nums[-1];
