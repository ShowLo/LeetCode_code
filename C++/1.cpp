class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) 
    {
        int len = nums.capacity();
        vector<int> r;
        for(int i = 0;i < len;++i)
        {
            for(int j = i + 1;j < len;++j)
            {
                if(nums.at(i) + nums.at(j) == target)
                {
                    r.push_back(i);
                    r.push_back(j);
                }
            }
        }
        return r;
    }
};