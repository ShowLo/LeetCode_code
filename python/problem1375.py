class Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        blue = [False for _ in range(50001)]
        visited = blue.copy()
        blue[0] = True
        count, maxIdx = 0, 0
        for i in range(len(light)):
            idx = light[i]
            maxIdx = idx if idx > maxIdx else maxIdx        #更新最右灯编号
            visited[idx] = True
            if blue[idx - 1]:                               #只有当前灯左边是蓝的才有必要继续下去
                blue[idx] = True                            #当前灯可以变蓝了
                if idx == maxIdx:                           #当前灯是最右灯，所以计数+1
                    count += 1
                else:
                    idx += 1
                    while idx <= maxIdx and visited[idx]:   #当前灯不是最右的时候需要判断右边灯直到最右的灯是否都亮着
                        blue[idx] = True
                        idx += 1
                    if idx == maxIdx + 1:                   #都亮着的情况下计数才+1
                        count += 1
        return count
