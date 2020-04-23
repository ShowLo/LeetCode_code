class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foods = new TreeSet<>();
        for (List<String> order : orders) {
            String food = order.get(2);
            foods.add(food);
        }
        Map<String, Integer> food2idx = new HashMap<>();
        int count = 1;
        for (String food : foods) {
            food2idx.put(food, count++);
        }
        int[][] id2foodCount = new int[501][foods.size() + 1];
        for (List<String> order : orders) {
            int id = Integer.parseInt(order.get(1));
            int foodId = food2idx.get(order.get(2));
            ++id2foodCount[id][foodId];
            id2foodCount[id][0] = 1;
        }
        List<List<String>> result = new LinkedList<>();
        List<String> first = new LinkedList<>();
        first.add("Table");
        for (String food : foods) {
            first.add(food);
        }
        result.add(first);
        for (int i = 0; i <= 500; ++i) {
            if (id2foodCount[i][0] == 1) {
                List<String> item = new LinkedList<>();
                item.add(String.valueOf(i));
                for (String food : foods) {
                    item.add(String.valueOf(id2foodCount[i][food2idx.get(food)]));
                }
                result.add(item);
            }
        }
        return result;
    }
}
