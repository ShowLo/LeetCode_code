class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        result = []
        stackLen = 0
        for s in seq:
            if s == '(':
                stackLen += 1
                result.append(stackLen % 2)
            else:
                result.append(stackLen % 2)
                stackLen -= 1
        return result
