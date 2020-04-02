class Solution:
    def numTeams(self, rating: List[int]) -> int:
        N = len(rating)
        result = 0
        for middle in range(1, N - 1):
            leftLargerNum, rightLargerNum = 0, 0
            for left in range(middle):
                if rating[left] > rating[middle]:
                    leftLargerNum += 1
            for right in range(middle + 1, N):
                if rating[right] > rating[middle]:
                    rightLargerNum += 1
            result += (middle - leftLargerNum) * rightLargerNum + leftLargerNum * (N - 1 - middle - rightLargerNum)
        return result
