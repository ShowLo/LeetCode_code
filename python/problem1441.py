class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        result = []
        count = 1
        for i in target:
            if i == count:
                result.append("Push")
            else:
                while count < i:
                    count += 1
                    result.append("Push")
                    result.append("Pop")
                result.append("Push")
            count += 1
        return result
