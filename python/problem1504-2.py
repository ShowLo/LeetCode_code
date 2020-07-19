class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        height = mat
        row, col = len(mat), len(mat[0])
        for i in range(1, row):
            for j in range(col):
                if height[i][j] == 1:
                    height[i][j] = height[i - 1][j] + 1
        result = 0
        for i in range(row):
            # 高递增的单调栈，存放[高，宽]
            stack = []
            # 累加前面的全1矩阵数
            cursum = 0
            for j in range(col):
                if height[i][j] == 0:
                    stack = []
                    cursum = 0
                    continue
                if not stack or height[i][j] > stack[-1][0]:
                    # 当前高度大于之前的最大高度的话
                    # 那么以当前点为右下角的全1矩阵数就是cursum+当前高度
                    # 其中cursum代表了宽度为2、3...的全1矩阵数
                    stack.append([height[i][j], 1])
                    cursum += height[i][j]
                    result += cursum
                else:
                    # 当前高度比之前的最大高度低的话
                    # 比当前高度高的那些都失去了对后面的影响，需要去掉
                    # 只留下一个更宽的以当前高度为高的矩形
                    curWidth = 1
                    while stack and stack[-1][0] >= height[i][j]:
                        h, w = stack.pop()
                        curWidth += w
                        # 因为将这些更高的高度降至跟当前高度一样
                        # 在这过程中失去的那些全1矩阵数需要减掉
                        cursum -= (h - height[i][j]) * w
                    stack.append([height[i][j], curWidth])
                    cursum += height[i][j]
                    result += cursum
        return result
