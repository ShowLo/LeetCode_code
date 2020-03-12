class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        if n == 1:
            return 1.0 if target == 1 and t >= 1 else 0.0
        father = [0 for _ in range(n + 1)]
        sonNum = father.copy()
        targetCount = 0
        for i, j in edges:                  #初始化各节点父节点，以及各节点的子节点数目
            if i < j:
                father[j] = i
                sonNum[i] += 1
            else:
                father[i] = j
                sonNum[j] += 1
            if i == target or j == target:  #统计target节点出现次数
                targetCount += 1
        idx = father[target]
        count = 0
        probability = 1.0
        while idx != 0:                     #从target往上走直到节点1
            count += 1                      #统计跳转次数（也即边数）
            probability /= sonNum[idx]      #计算从target到节点1的总概率
            idx = father[idx]
        #可以返回概率的情况：要么target节点是叶子节点，要么跳转次数刚好等于秒数t
        if (count < t and targetCount == 1 and target != 1) or count == t:
            return probability
        else:
            return 0.0
