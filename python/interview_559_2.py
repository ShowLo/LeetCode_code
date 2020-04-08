class MaxQueue:

    def __init__(self):
        self.originalQueue = collections.deque()    #记录原本的队列
        self.maxValueQueue = collections.deque()    #用来专门记录最大值的一个非增队列


    def max_value(self) -> int:
        return self.maxValueQueue[0] if self.maxValueQueue else -1

    def push_back(self, value: int) -> None:
        self.originalQueue.append(value)
        while self.maxValueQueue and self.maxValueQueue[-1] < value:
            self.maxValueQueue.pop()                #当入队列时，对于最大值队列中尾部小于当前入队值的全部出队列
        self.maxValueQueue.append(value)

    def pop_front(self) -> int:
        if not self.maxValueQueue:
            return -1
        else:
            temp = self.originalQueue.popleft()
            if temp == self.maxValueQueue[0]:
                self.maxValueQueue.popleft()
            return temp


# Your MaxQueue object will be instantiated and called as such:
# obj = MaxQueue()
# param_1 = obj.max_value()
# obj.push_back(value)
# param_3 = obj.pop_front()
