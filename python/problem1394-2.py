class Solution:
    def findLucky(self, arr: List[int]) -> int:
        count = [0 for _ in range(501)]
        for a in arr:
            count[a] += 1
        for i in range(500, 0, -1):
            if count[i] == i:
                return i
        return -1
