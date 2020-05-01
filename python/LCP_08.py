class Solution:
    def getTriggerTime(self, increase: List[List[int]], requirements: List[List[int]]) -> List[int]:
        N = len(increase)
        for i in range(1, N):
            for j in range(3):
                increase[i][j] += increase[i - 1][j]
        
        c = [0] * (increase[N - 1][0] + 1)
        r = [0] * (increase[N - 1][1] + 1)
        h = [0] * (increase[N - 1][2] + 1)
        count = 1
        for i in range(1, increase[0][0] + 1):
            c[i] = count
        for i in range(1, increase[0][1] + 1):
            r[i] = count
        for i in range(1, increase[0][2] + 1):
            h[i] = count
        for i in range(1, N):
            count += 1
            if increase[i][0] > increase[i - 1][0]:
                for j in range(increase[i][0], 0, -1):
                    if c[j] != 0:
                        break
                    c[j] = count
            if increase[i][1] > increase[i - 1][1]:
                for j in range(increase[i][1], 0, -1):
                    if r[j] != 0:
                        break
                    r[j] = count
            if increase[i][2] > increase[i - 1][2]:
                for j in range(increase[i][2], 0, -1):
                    if h[j] != 0:
                        break
                    h[j] = count

        result = []
        for require in requirements:
            if require[0] > increase[N - 1][0] or require[1] > increase[N - 1][1] or require[2] > increase[N - 1][2]:
                result.append(-1)
                continue
            result.append(max(c[require[0]], max(r[require[1]], h[require[2]])))
        return result
