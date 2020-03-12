class Solution {
    private Map<Integer, List<Integer>> manager2sub;

    private int maxMins(int id, int[] informTime) {
        if (informTime[id] > 0) {
            List<Integer> subs = manager2sub.get(id);
            int maxTime = 0;
            for (int i : subs) {
                int subTime = maxMins(i, informTime);
                if (subTime > maxTime) {
                    maxTime = subTime;
                }
            }
            return informTime[id] + maxTime;
        }
        else {
            return 0;
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        manager2sub = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> tmp = manager2sub.containsKey(manager[i]) ? manager2sub.get(manager[i]) : new LinkedList<>();
            tmp.add(i);
            manager2sub.put(manager[i], tmp);
        }
        return maxMins(headID, informTime);
    }
}
