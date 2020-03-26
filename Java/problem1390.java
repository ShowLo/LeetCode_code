class Solution {
    private int factorSum(int n) {
        int sqrtN = (int)Math.sqrt(n);
        int count = 0;
        int sum = 0;
        for (int i = 2; i <= sqrtN; ++i) {
            if (n % i == 0) {
                ++count;
                int another = n / i;
                if (i != another) {
                    sum = i + another;
                    ++count;
                }
                if (count > 2) {
                    break;
                }
            }
        }
        if (count == 2) {
            return sum + 1 + n;
        }
        return 0;
    }
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int n : nums) {
            result += factorSum(n);
        }
        return result;
    }
}
