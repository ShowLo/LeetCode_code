class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        name2k = {}
        result = []
        for name in names:
            if name not in name2k:
                result.append(name)
                name2k[name] = 0
            else:
                k = name2k[name] + 1
                s = name + '(' + str(k) + ')'
                while s in name2k:
                    k += 1
                    s = name + '(' + str(k) + ')'
                result.append(s)
                name2k[s] = 0
                name2k[name] = k
        return result
