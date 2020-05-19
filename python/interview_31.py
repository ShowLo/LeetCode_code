class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        popIdx = 0
        stack = []
        for p in pushed:
            if p == popped[popIdx]:
                popIdx += 1
                while len(stack) > 0 and stack[-1] == popped[popIdx]:
                    stack.pop()
                    popIdx += 1
            else:
                stack.append(p)
        return len(stack) == 0
