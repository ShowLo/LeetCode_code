class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = [0 for _ in range(maxSize)]
        self.maxSize = maxSize
        self.length = 0

    def push(self, x: int) -> None:
        if self.length < self.maxSize:
            self.stack[self.length] = x
            self.length += 1

    def pop(self) -> int:
        if self.length > 0:
            self.length -= 1
            return self.stack[self.length]
        return -1

    def increment(self, k: int, val: int) -> None:
        k = self.length if self.length < k else k
        for i in range(k):
            self.stack[i] += val



# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)
