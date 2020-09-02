class Solution:
    
    def minInteger(self, num: str, k: int) -> str:
        if k == 0 or not num:
            return num
        for i in range(10):
            idx = num.find(str(i))
            if 0 <= idx <= k:
                return num[idx] + self.minInteger(num[0:idx] + num[idx + 1:], k - idx)
