class Solution:
    def verifyPostorder(self, postorder: List[int]) -> bool:
        def isValid(left, right):
            if left >= right:
                return True
            i = left
            while i < right:
                if postorder[i] > postorder[right]:
                    break
                i += 1
            j = i
            while j < right:
                if postorder[j] < postorder[right]:
                    return False
                j += 1
            return isValid(left, i - 1) and isValid(i, right - 1)
        return isValid(0, len(postorder) - 1)
