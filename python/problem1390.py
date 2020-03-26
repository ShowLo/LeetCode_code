class Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        def factor4num(n):
            sqrtN = (int)(math.sqrt(n))
            count = 0
            sum4factor = 0
            for i in range(2, sqrtN + 1):
                if n % i == 0:
                    count += 1
                    if i != n // i:                 #不能是平方根，否则不可能刚好有4个因数
                        sum4factor += i + n // i
                        count += 1
                    if count > 2:                   #一定超过4个了
                        break
            if count == 2:
                return sum4factor + 1 + n
            return 0
        
        result = 0
        for n in nums:
            result += factor4num(n)
        return result
