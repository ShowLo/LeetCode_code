class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        result = []
        out = []
        def recursion(index, result, out, candidates, target):
            cLen = len(candidates)
            for i in range(index, cLen):
                num = candidates[i]
                if num == target:
                    out.append(num)
                    result.append(out)
                    break
                elif num < target:
                    temp = [r for r in out]
                    temp.append(num)
                    recursion(i, result, temp, candidates, target - num)
                else:
                    break
        recursion(0, result, out, candidates, target)
        return result