class Solution:
    '''
    def binarySearch(self, arr, target):
        left, right = 0, len(arr) - 1
        while left < right:
            middle = (left + right) // 2
            if arr[middle] <= target:
                left = middle + 1
            else:
                right = middle
        return right
    '''

    def avoidFlood(self, rains: List[int]) -> List[int]:
        rains2idx = {}
        zeros = []
        result = [-1] * len(rains)
        for i, r in enumerate(rains):
            if r > 0:
                if r in rains2idx:
                    prev = rains2idx[r]
                    if len(zeros) == 0 or zeros[-1] < prev:
                        return []
                    # idx = self.binarySearch(zeros, prev)
                    # result[zeros.pop(idx)] = r
                    for j, idx in enumerate(zeros):
                        if idx > prev:
                            result[idx] = r
                            zeros.pop(j)
                            break
                rains2idx[r] = i
            else:
                zeros.append(i)
        for z in zeros:
            result[z] = 1
        return result
