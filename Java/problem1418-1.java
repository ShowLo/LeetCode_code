class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<Integer> ids = new HashSet<>();
        Set<String> foods = new HashSet<>();
        Map<Integer, Map<String, Integer>> id2food = new HashMap<>();
        for (List<String> order : orders) {
            int id = Integer.parseInt(order.get(1));
            String food = order.get(2);
            ids.add(id);
            foods.add(food);
            Map<String, Integer> foodMap = id2food.getOrDefault(id, new HashMap<>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            id2food.put(id, foodMap);
        }
        List<Integer> sortId = new ArrayList<>(ids);
        Collections.sort(sortId);
        List<String> sortFood = new ArrayList<>(foods);
        Collections.sort(sortFood);
        List<List<String>> result = new LinkedList<>();
        List<String> first = new LinkedList<>();
        first.add("Table");     
        for (String f : sortFood) {
            first.add(f);
        }
        result.add(first);
        for (int si : sortId) {
            List<String> item = new LinkedList<>();
            item.add(String.valueOf(si));
            Map<String, Integer> fm = id2food.get(si);
            for (String sf : sortFood) {
                item.add(String.valueOf(fm.getOrDefault(sf, 0)));
            }
            result.add(item);
        }
        return result;
    }
}
