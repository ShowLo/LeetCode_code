class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        ids = set()
        foods = set()
        id2food = {}
        for order in orders:
            id_table = (int)(order[1])
            ids.add(id_table)
            foods.add(order[2])
            if id_table in id2food:
                if order[2] in id2food[id_table]:
                    id2food[id_table][order[2]] += 1
                else:
                    id2food[id_table][order[2]] = 1
            else:
                id2food[id_table] = {order[2] : 1}
        sortId = sorted(list(ids))
        sortFood = sorted(list(foods))
        result = [['Table']]
        for food in sortFood:
            result[0].append(food)
        for si in sortId:
            item = []
            item.append(str(si))
            for food in sortFood:
                if food in id2food[si]:
                    item.append(str(id2food[si][food]))
                else:
                    item.append('0')
            result.append(item)
        return result
