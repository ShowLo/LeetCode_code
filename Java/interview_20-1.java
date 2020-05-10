class Solution {
    private boolean isDigits(String num, boolean prev) {
        char[] nums = num.toCharArray();
        if (nums.length == 0) {
            return false;
        }
        if (!(Character.isDigit(nums[0]) || (nums[0] == '.' && nums.length > 1))) {
            return false;
        }
        boolean findPoint = prev == false;
        for (char c : nums) {
            if (c == '.') {
                if (findPoint) {
                    return false;
                }
                else {
                    findPoint = true;
                }
            }
            else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0 || s.charAt(0) == 'e' || s.charAt(s.length() - 1) == 'e') {
            return false;
        }
        String[] nums = s.split("e");
        if (nums.length > 2 || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                return isDigits(nums[0].substring(1), true);
            }
            else {
                return isDigits(nums[0], true);
            }
        }
        else {
            if (nums[0].length() == 0 || nums[1].length() == 0) {
                return false;
            }
            boolean prev;
            if (nums[0].charAt(0) == '+' || nums[0].charAt(0) == '-') {
                prev = isDigits(nums[0].substring(1), true);
            }
            else {
                prev = isDigits(nums[0], true);
            }
            boolean behind;
            if (nums[1].charAt(0) == '+' || nums[1].charAt(0) == '-') {
                behind = isDigits(nums[1].substring(1), false);
            }
            else {
                behind = isDigits(nums[1], false);
            }
            return prev && behind;
        }
    }
}
