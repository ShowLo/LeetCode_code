class Solution:

    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        residual2num = {}
        count = 0
        for a in A:
            for b in B:
                num = 0 - a - b
                if num in residual2num:     #整合A和B各个数的组合，以0-a-b作为key，出现次数作为value
                    residual2num[num] += 1
                else:
                    residual2num[num] = 1
        for c in C:
            for d in D:
                num = c + d
                if num in residual2num:     #只要c+d出现在字典中，说明出现一个符合的四元组
                    count += residual2num[num]
        return count
