class Solution:
    def numOfWays(self, n: int) -> int:
        ABC, ABA = 6, 6
        mod = 1000000007
        for _ in range(n - 1):
            ABC, ABA = 2 * ABC + 2 * ABA, 2 * ABC + 3 * ABA
        return (ABC + ABA) % mod
