class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.leftHeap = []
        self.rightHeap = []

    def addNum(self, num: int) -> None:
        leftLen = len(self.leftHeap)
        rightLen = len(self.rightHeap)
        if leftLen == rightLen:
            if leftLen == 0 or num < self.rightHeap[0]:
                heapq.heappush(self.leftHeap, -num)
            else:
                heapq.heappush(self.leftHeap, -heapq.heappop(self.rightHeap))
                heapq.heappush(self.rightHeap, num)
        else:
            if num > -self.leftHeap[0]:
                heapq.heappush(self.rightHeap, num)
            else:
                heapq.heappush(self.rightHeap, -heapq.heappop(self.leftHeap))
                heapq.heappush(self.leftHeap, -num)

    def findMedian(self) -> float:
        return -self.leftHeap[0] if (len(self.leftHeap) + len(self.rightHeap)) % 2 == 1 else (-self.leftHeap[0] + self.rightHeap[0]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
