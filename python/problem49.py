class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        strDict = {}
        for str in strs:
            s = list(str)
            s.sort()
            sortStr = "".join(s)
            if sortStr not in strDict:
                strDict[sortStr] = [str]
            else:
                strDict[sortStr].append(str)
        retList = []
        for value in strDict.values():
            retList.append(value)
        return retList