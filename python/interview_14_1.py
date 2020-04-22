class Solution:
    def cuttingRope(self, n: int) -> int:
        result = 0
        for i in range(2, n + 1):
            ave = n // i
            res = n % i
            cur = (int)(math.pow(ave, i - res) * math.pow(ave + 1, res))
            result = max(result, cur)
        return result
