class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        for (int middle = 1; middle < rating.length - 1; ++middle) {
            int leftLargerNum = 0, rightLargerNum = 0;
            for (int left = 0; left < middle; ++left) {
                if (rating[left] > rating[middle]) {
                    ++leftLargerNum;
                }
            }
            for (int right = middle + 1; right < rating.length; ++right) {
                if (rating[right] > rating[middle]) {
                    ++rightLargerNum;
                }
            }
            result += (middle-leftLargerNum) * rightLargerNum + leftLargerNum * (rating.length-1-middle-rightLargerNum);
        }
        return result;
    }
}
