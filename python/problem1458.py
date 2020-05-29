class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        m = len(nums1)
        n = len(nums2)
        if m < n:
            return self.maxDotProduct(nums2, nums1)
        dp = [0] * n
        dp[0] = nums1[0] * nums2[0]
        maxN = minN = nums2[0]
        for j in range(1, n):
            maxN = max(maxN, nums2[j])
            minN = min(minN, nums2[j])
            dp[j] = maxN * nums1[0] if nums1[0] > 0 else minN * nums1[0]
        maxN = minN = nums1[0]
        for i in range(1, m):
            dp_i_1_j_1 = dp[0]
            maxN = max(maxN, nums1[i])
            minN = min(minN, nums1[i])
            dp[0] = maxN * nums2[0] if nums2[0] > 0 else minN * nums2[0]
            for j in range(1, n):
                tmp = dp[j]
                dp[j] = max(nums1[i] * nums2[j], dp_i_1_j_1 + nums1[i] * nums2[j],
                    dp_i_1_j_1, dp[j - 1], tmp)
                dp_i_1_j_1 = tmp
        return dp[n - 1]
