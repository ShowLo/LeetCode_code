class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        if m == 0:
            return (nums2[n//2 - 1] + nums2[n//2]) / 2 if n % 2 == 0 else nums2[n//2]
        iMin, iMax = 0, m
        middle = (m + n + 1) // 2
        while iMin <= iMax:
            i = iMin + (iMax - iMin) // 2
            j = middle - i
            if i > 0 and nums1[i - 1] > nums2[j]:
                iMax = i - 1
            elif i < m and nums1[i] < nums2[j - 1]:
                iMin = i + 1
            else:
                middleNum, middleNum_1 = 0, 0
                if i == 0:
                    middleNum = nums2[j - 1]
                elif j == 0:
                    middleNum = nums1[i - 1]
                else:
                    middleNum = max(nums1[i - 1], nums2[j - 1])
                if (m + n) % 2 == 1:
                    return middleNum
                if i == m:
                    middleNum_1 = nums2[j]
                elif j == n:
                    middleNum_1 = nums1[i]
                else:
                    middleNum_1 = min(nums1[i], nums2[j])
                return (middleNum + middleNum_1) / 2
        return 0.0
