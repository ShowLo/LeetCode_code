class Solution {
    public String[] getFolderNames(String[] names) {
        String[] result = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (!map.containsKey(names[i])) {
                result[i] = names[i];
                map.put(names[i], 0);
            }
            else {
                int k = map.get(names[i]) + 1;
                String s = names[i] + "(" + k + ")";
                while (map.containsKey(s)) {
                    s = names[i] + "(" + (++k) + ")";
                }
                result[i] = s;
                map.put(names[i], k);
                map.put(s, 0);
            }
        }
        return result;
    }
}
