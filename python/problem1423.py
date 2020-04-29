class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        N = len(cardPoints)
        result = sum(cardPoints[0 : k])
        curSum = result
        for i in range(k):
            curSum += cardPoints[N - 1 - i] - cardPoints[k - 1 - i]
            result = max(result, curSum)
        return result
