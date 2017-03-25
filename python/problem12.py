class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        ones = ['','I','II','III','IV','V','VI','VII','VIII','IX'];
        tens = ['','X','XX','XXX','XL','L','LX','LXX','LXXX','XC'];
        hundreds = ['','C','CC','CCC','CD','D','DC','DCC','DCCC','CM'];
        thousands = ['','M','MM','MMM'];
        return thousands[num // 1000] + hundreds[(num % 1000) // 100] + tens[(num % 100) // 10] + ones[num % 10];