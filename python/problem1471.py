class Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        arr.sort()
        n = len(arr)
        m = arr[(n - 1) // 2]
        result = []
        count = 0
        left, right = 0, n - 1
        while count < k:
            if m - arr[left] > arr[right] - m:
                result.append(arr[left])
                left += 1
            else:
                result.append(arr[right])
                right -= 1
            count += 1
        return result
