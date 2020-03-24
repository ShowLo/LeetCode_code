class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        speedAndEff = list(zip(speed, efficiency))              #组成(speed, efficiency)
        speedAndEff.sort(key=lambda x : x[1], reverse=True)     #按efficiency降序排序

        import heapq
        topk = []
        maxResult, totalSpeed = 0, 0
        for i in range(k):                                      #前k个全部加入最小堆中，同时计算最大表现值（可以小于k个人）
            heapq.heappush(topk, speedAndEff[i][0])
            totalSpeed += speedAndEff[i][0]
            maxResult = max(maxResult, totalSpeed * speedAndEff[i][1])

        for i in range(k, n):                                   #对于k个之后的，只有speed大于当前最小speed的才有必要继续计算
            if speedAndEff[i][0] > topk[0]:
                totalSpeed = totalSpeed - topk[0] + speedAndEff[i][0]
                heapq.heapreplace(topk, speedAndEff[i][0])
                maxResult = max(maxResult, totalSpeed * speedAndEff[i][1])
        
        return maxResult % 1000000007
