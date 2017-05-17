public class Solution
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0)                           //如果只存在第二组数
        {
            if(len2%2 == 0)                     //如果数的个数为偶数，就返回中间两个数的平均数
                return (nums2[len2/2 - 1] + nums2[len2/2])/2.;
            else                                //如果数的个数为奇数，就返回中间的数
                return nums2[len2/2];
        }
        else if(len2 == 0)                      //如果只存在第一组数
        {
            if(len1%2 == 0)
                return (nums1[len1/2 - 1] + nums1[len1/2])/2.;
            else
                return nums1[len1/2];
        }
        if(len1 == 1 && len2 == 1)              //如果两组数都是只有一个数
            return (nums1[0] + nums2[0])/2.;     //直接返回两个数的平均值
        int length = len1 + len2, count = 0;;
        int index1 = 0, index2 = 0;
        int[] nums =new int[length/2 + 1];
        for(int i = 0; i < length/2 + 1; ++i)   //进行整合排序，不用将数组1、2的数全部整合排序，只需进行一半即可
        {
            
            //在索引1没越界时，索引2到达数组尾部了或者此时在第一组数中索引1对应的数小于第二组数最后一个数
            if(index1 < len1 && (index2 == len2 || nums1[index1] < nums2[index2]))
            {
                nums[count++] = nums1[index1];  //那就将第一组数中的数继续加到整合排序的数组中去
                ++index1;                       //然后继续对第一组数中的数进行以上操作
            }
            else                                //否则的话就将第二组数中索引2对应的数加到整合排序的数组中去
            {
                nums[count++] = nums2[index2];
                ++index2;                       //然后对于第二组数中的数继续进行以上操作
            }
        }
        if(length % 2 == 0)                     //两个数组的数的个数和为偶数的话，返回中间两个数的平均值
            return (nums[length/2 - 1] + nums[length/2])/2.;
        else
            return nums[length/2];              //否则只需返回中间那个数
 
    }
}