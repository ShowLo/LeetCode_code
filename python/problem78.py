class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        #C(n, k) = C(n - 1, k - 1) + C(n - 1, k)
        result = []
        if n < k or k < 1 or n < 1:
            return result
        result = self.combine(n - 1, k - 1)
        if len(result) == 0:
            result.append([n])
        else:
            for i in range(len(result)):
                result[i].append(n)
        result2 = self.combine(n - 1, k)
        for r in result2:
            result.append(r)
        return result