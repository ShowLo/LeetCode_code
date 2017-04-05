class Solution(object):
	#超时，稍后改进
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort();                                        #先排序
        greaterThanZero = [x for x in nums if x > 0];       #挑出大于零的数
        lessOrEqualZero = [x for x in nums if x <= 0];      #挑出小于等于零的数
        target_GTZ = [-x for x in greaterThanZero][::-1];   #如果三个数里有负数，则必有正数，对正数取反即为另两个数之和
        length_LEZ = len(lessOrEqualZero);
        length_GTZ = len(greaterThanZero);
        result = [];
        if length_LEZ == 0:                                 #全是正数，直接返回空
            return result;
        for i in range(length_LEZ):
            for j in range(i + 1,length_LEZ):               #由于排好了序，直接从下一个数开始
                LEZ_i = lessOrEqualZero[i];
                LEZ_j = lessOrEqualZero[j];
                sum_ij = LEZ_i + LEZ_j;
                if sum_ij in target_GTZ:                    #三个数加起来为零
                    triplet = [LEZ_i,LEZ_j,-sum_ij];
                    if triplet not in result:               #在此之前没被加进来
                        result.append(triplet);
        zero = [x for x in nums if x == 0];                 #找出所有零，大于三个的话可以加入[0,0,0]
        if len(zero) >= 3:
            result.append([0,0,0]);
        greaterOrEqualZero = zero + greaterThanZero;        #挑出大于等于零的数
        target_LTZ = [-x for x in nums if x < 0];           #如果三个数里有正数，则必有负数，对负数取反即为另两个数之和
        length_GEZ = len(greaterOrEqualZero);
        for i in range(length_GEZ):
            for j in range(i + 1,length_GEZ):
                GEZ_i = greaterOrEqualZero[i];
                GEZ_j = greaterOrEqualZero[j];
                sum_ij = GEZ_i + GEZ_j;
                if sum_ij in target_LTZ:
                    triplet = [-sum_ij,GEZ_i,GEZ_j];
                    if triplet not in result:
                        result.append(triplet);
        return result;