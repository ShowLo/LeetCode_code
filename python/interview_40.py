class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        N = 10001
        record = [0 for _ in range(N)]
        for a in arr:
            record[a] += 1
        idx = 0
        result = []
        for i in range(N):
            if record[i] > 0:
                for j in range(record[i]):
                    if idx < k:
                        result.append(i)
                        idx += 1
                    else:
                        break
                if idx == k:
                    break
        return result
