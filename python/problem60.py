class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        num = 1
        for i in range(2, n):       #计算(n-1)!
            num *= i
        oneToN = [str(i) for i in range(1, n + 1)]
        result = []
        count = n - 1
        while count > 0:
            index = (k - 1) // num
            k = k % num
            result.append(oneToN[index])
            oneToN.pop(index)
            num /= count
            count -= 1
        result.append(oneToN[0])
        return ''.join(result)