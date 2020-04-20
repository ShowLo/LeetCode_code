class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        n = len(queries)
        tree = [0 for _ in range(n + m + 1)]

        def lowbit(x):
            return x & (-x)

        def update(idx, value):
            while idx <= n + m:
                tree[idx] += value
                idx += lowbit(idx)
        
        def getSum(idx):
            s = 0
            while idx > 0:
                s += tree[idx]
                idx -= lowbit(idx)
            return s

        value2index = [n + i for i in range(m + 1)]
        for i in range(n + 1, n + m + 1):
            update(i, 1)
        
        result = []
        for i in range(n):
            indexQuery = value2index[queries[i]]
            result.append(getSum(indexQuery) - 1)
            update(indexQuery, -1)
            update(n - i, 1)
            value2index[queries[i]] = n - i

        return result
