class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        sLen1, sLen2 = len(str1), len(str2)
        if sLen1 < sLen2:
            return self.gcdOfStrings(str2, str1)
        n = sLen1 // sLen2
        for i in range(n):
            if not str2 == str1[i * sLen2 : (i + 1) * sLen2]:   #取模操作前需判断是否能取模
                return ''
        if sLen1 % sLen2 == 0:
            return str2
        return self.gcdOfStrings(str2, str1[n * sLen2 :])       #第二个参数即为取模之后的字符串
