class Solution:
    def peopleIndexes(self, favoriteCompanies: List[List[str]]) -> List[int]:
        setList = [set(f) for f in favoriteCompanies]
        setList.sort(key = lambda x : len(x), reverse=True)
        N = len(favoriteCompanies)
        result = []
        for i in range(N):
            set_i = set(favoriteCompanies[i])
            len_i = len(set_i)
            isSubset = False
            j = 0
            while j < N and len(setList[j]) > len_i:
                if set_i.issubset(setList[j]):
                    isSubset = True
                    break
                j += 1
            if not isSubset:
                result.append(i)
        return result
