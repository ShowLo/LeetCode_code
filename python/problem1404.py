class Solution:
    def numSteps(self, s: str) -> int:
        L = len(s)
        count = 0
        carry = False
        for i in range(L - 1, -1, -1):
            if i == 0 and not carry:
                break
            if (carry and s[i] == '0') or (not carry and s[i] == '1'):
                count += 1
                carry = True
            count += 1
        return count
