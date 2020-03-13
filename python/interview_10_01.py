class Solution:
    def merge(self, A: List[int], m: int, B: List[int], n: int) -> None:
        """
        Do not return anything, modify A in-place instead.
        """
        index1, index2 = m - 1, n - 1
        while index1 >=0 and index2 >= 0:           #从后往左填充A数组
            if A[index1] > B[index2]:               #当前A元素大于B元素，则填充A元素，A的索引左移
                A[index1 + index2 + 1] = A[index1]
                index1 -= 1
            else:                                   #否则需要填充B元素，同样B的索引左移
                A[index1 + index2 + 1] = B[index2]
                index2 -= 1
        if index1 == -1:                            #B的元素还有部分未填充，全部填到A的头部去
            while index2 >= 0:
                A[index2] = B[index2]
                index2 -= 1
