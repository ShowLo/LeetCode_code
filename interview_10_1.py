class Solution:
    def fib(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        F0, F1 = 0, 1
        for _ in range(2, n + 1):
            F0, F1 = F1, (F0 + F1) % 1000000007
        return F1
