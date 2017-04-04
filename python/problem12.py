class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        ones = ['','I','II','III','IV','V','VI','VII','VIII','IX'];     #个位数所对应罗马数字
        tens = ['','X','XX','XXX','XL','L','LX','LXX','LXXX','XC'];     #十位数所对应罗马数字
        hundreds = ['','C','CC','CCC','CD','D','DC','DCC','DCCC','CM']; #百位数所对应罗马数字
        thousands = ['','M','MM','MMM'];                                #千位数所对应罗马数字
        return thousands[num // 1000] + hundreds[(num % 1000) // 100] + tens[(num % 100) // 10] + ones[num % 10];
