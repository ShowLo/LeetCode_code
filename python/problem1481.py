class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        count = collections.defaultdict(int)
        for n in arr:
            count[n] += 1
        values = list(count.values())
        values.sort()
        removeCount = 0
        for v in values:
            if v <= k:
                k -= v
                removeCount += 1
            else:
                break
        return len(values) - removeCount
