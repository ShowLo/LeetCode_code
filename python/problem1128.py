class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        recordLst = [0 for i in range(100)]     #数字最大为99
        count = 0
        for x, y in dominoes:
            key = min(x, y) * 10 + max(x, y)    #[1,2]->12, [2,1]->12
            count += recordLst[key]             #(n+1)n/2-n(n-1)/2=n
            recordLst[key] += 1
        return count
