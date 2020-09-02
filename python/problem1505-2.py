class Solution:
    
    def minInteger(self, num: str, k: int) -> str:
        n = len(num)
        digits = [str(i) for i in range(10)]
        # 线段树上0代表未被换到前面去，1代表被换了
        # 所以getSum得到的就是当前位置前面被换过了的数量
        # 等价于未处理字符串的开头位置
        segmentTree = SegmentTree(n)
        # 记录0~9各个数字的位置
        position = [[] for _ in range(10)]
        for i in range(n - 1, -1, -1):
            position[int(num[i])].append(i)
        res = []
        i = 0
        while i < n:
            digit = int(num[i])
            if not position[digit] or position[digit][-1] > i:
                # 已经被交换过的了，忽略掉
                i += 1
                continue
            for j in range(digit + 1):
                if not position[j]:
                    continue
                # 在num中的索引
                originIdx = position[j][-1]
                # 找到一个比num[i]小的了，但还需要看距离是否够
                count = segmentTree.getSum(originIdx + 1)
                # 实际需要多少次的交换
                needCount = originIdx - count
                if needCount <= k:
                    k -= needCount
                    position[j].pop()
                    res.append(str(j))
                    segmentTree.update(originIdx + 1, 1)
                    break
        return ''.join(res)


class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (n + 1)
    
    def lowbit(self, x):
        return x & (-x)
    
    def update(self, i, x):
        while i <= self.n:
            self.tree[i] += x
            i += self.lowbit(i)

    def getSum(self, i):
        res = 0
        while i > 0:
            res += self.tree[i]
            i -= self.lowbit(i)
        return res
