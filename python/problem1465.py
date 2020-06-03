class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts.sort()
        verticalCuts.sort()
        horizontalCuts.append(h)
        verticalCuts.append(w)
        hMax = 0
        prev = 0
        for hc in horizontalCuts:
            hMax = max(hMax, hc - prev)
            prev = hc
        vMax = 0
        prev = 0
        for vc in verticalCuts:
            vMax = max(vMax, vc - prev)
            prev = vc
        return (hMax * vMax) % 1000_000_007
