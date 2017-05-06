public class Solution
{
    public int[] twoSum(int[] nums, int target) 
    {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length;++i)
        {
            if(map.containsKey(nums[i]))            //如果Map中已有当前值，说明找到了符合条件的一对数
            {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i],i);            //如果Map中并没有当前值，那就把目标值与当前值的差作为键，索引作为值
        }
        return result;
    }
}