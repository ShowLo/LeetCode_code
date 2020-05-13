class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        curXor = 0
        result = 0
        xor2countAndSum = {0 : [1, 0]}
        for i in range(len(arr)):
            curXor ^= arr[i]
            if curXor in xor2countAndSum:
                countAndSum = xor2countAndSum[curXor]
                result += countAndSum[0] * i - countAndSum[1]
                countAndSum[0] += 1
                countAndSum[1] += i + 1
                xor2countAndSum[curXor] = countAndSum
            else:
                countAndSum = [1, i + 1]
                xor2countAndSum[curXor] = countAndSum
        return result
