class Solution:
    def isMonotonic(self, A: List[int]) -> bool:
        if A[0] < A[-1]:
            for i in range(len(A) - 1):
                if A[i] > A[i + 1]:
                    return False
            return True
        else:
            for i in range(len(A) - 1):
                if A[i] < A[i + 1]:
                    return False
            return True
