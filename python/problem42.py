class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 2:                #至少要块板的都可能盛得下水
            return 0
        maxHeight = max(height)
        if maxHeight < 1:                   #最高的板都只是0高度，不能盛水
            return 0
        maxIndex = height.index(maxHeight)
        waterLeft = []
        waterRight = []
        #对目前最高板的左边进行递归
        self.leftRecursion(height[:maxIndex], waterLeft)
        #对目前最高板的右边进行递归
        self.rightRecursion(height[maxIndex + 1:], waterRight)
        return sum(waterLeft) + sum(waterRight)
        
    def leftRecursion(self, height, water):
        if len(height) < 2:
            return
        maxHeight = max(height)
        if maxHeight < 1:
            return
        maxIndex = height.index(maxHeight)
        #之前最高板的左边序列的最高板即次高板，这两板之间所能盛下的水
        water.append(sum([maxHeight - h for h in height[maxIndex + 1:]]))
        #把次高板当做当前最高板，对其左边继续进行递归计算
        self.leftRecursion(height[:maxIndex], water)
    
    def rightRecursion(self, height, water):
        if len(height) < 2:
            return
        maxHeight = max(height)
        if maxHeight < 1:
            return
        maxIndex = height.index(maxHeight)
        #之前最高板的右边序列的最高板即次高板，这两板之间所能盛下的水
        water.append(sum([maxHeight - h for h in height[:maxIndex]]))
        #把次高板当做当前最高板，对其右边继续进行递归计算
        self.rightRecursion(height[maxIndex + 1:], water)