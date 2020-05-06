class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        start2end = {}
        for path in paths:
            start2end[path[0]] = path[1]
        start = paths[0][0]
        while start in start2end:
            start = start2end[start]
        return start
