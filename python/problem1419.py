class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        if len(croakOfFrogs) % 5 != 0:
            return -1
        char2idx = {'c' : 0, 'r' : 1, 'o' : 2, 'a' : 3, 'k' : 4}
        counts = [0 for _ in range(5)]
        result = 0
        for c in croakOfFrogs:
            idx = char2idx[c]
            counts[idx] += 1
            if idx > 0 and counts[idx] > counts[idx - 1]:
                    return -1
            result = max(counts[idx], result)
            if idx == 4:
                for i in range(5):
                    counts[i] -= 1
        if sum(counts) > 0:
            return -1
        return result
