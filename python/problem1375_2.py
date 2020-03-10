class Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        count, maxIdx = 0, 0
        for i in range(len(light)):
            maxIdx = light[i] if light[i] > maxIdx else maxIdx
            if maxIdx == i + 1:
                count += 1
        return count
