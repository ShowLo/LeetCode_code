class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        int count = 1;
        for (int i = 0; i < target.length; ++i) {
            if (target[i] == count) {
                ++count;
                result.add("Push");
            }
            else {
                while (count < target[i]) {
                    result.add("Push");
                    result.add("Pop");
                    ++count;
                }
                result.add("Push");
                ++count;
            }
        }
        return result;
    }
}
