class Solution:
    def reformat(self, s: str) -> str:
        nums = list(filter(lambda x : x.isdigit(), s))
        letters = list(filter(lambda x : x.isalpha(), s))
        numLen = len(nums)
        letterLen = len(letters)
        if abs(numLen - letterLen) > 1:
            return ''
        result = ''
        if numLen < letterLen:
            for i in range(numLen):
                result += letters[i]
                result += nums[i]
            result += letters[-1]
        else:
            for i in range(letterLen):
                result += nums[i]
                result += letters[i]
            if numLen > letterLen:
                result += nums[-1]
        return result
