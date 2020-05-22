class Solution {
    private boolean contains(List<String> s1, Set<String> s2) {
        for (String s : s1) {
            if (!s2.contains(s)) {
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> setList = new LinkedList<>();
        int size = favoriteCompanies.size();
        for (int i = 0; i < size; ++i) {
            Set set = new HashSet(favoriteCompanies.get(i));
            setList.add(set);
        }
        Collections.sort(setList, new Comparator<Set<String>>() {
           @Override
            public int compare(Set<String> s1, Set<String> s2) {
                return s2.size() - s1.size();
            }
        });

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < size; ++i) {
            List<String> set_i = favoriteCompanies.get(i);
            int size_i = set_i.size();
            boolean contain = false;
            for (int j = 0; j < size && setList.get(j).size() > size_i; ++j) {
                if (contains(set_i, setList.get(j))) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                result.add(i);
            }
        }
        return result;
    }
}
