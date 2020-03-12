class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        toRootMins = [0 for _ in range(n)]
        def timeToRoot(id):
            if id == headID:            #总负责人
                return 0
            if toRootMins[id] != 0:     #已知当前员工节点到总负责人节点时间，直接返回
                return toRootMins[id]
            #已知当前员工节点的上司节点到总负责人节点时间，那就在这基础上加上上司节点到当前员工节点的时间，否则需要递归计算
            toRootMins[id] = (toRootMins[manager[id]] + informTime[manager[id]]) if toRootMins[manager[id]] != 0 else (timeToRoot(manager[id]) + informTime[manager[id]])
            return toRootMins[id]
        maxMins = 0
        for i in range(n):
            if informTime[i] == 0:      #只需要考虑叶子节点也即最下层员工节点
                tmp = timeToRoot(i)
                if tmp > maxMins:
                    maxMins = tmp
        return maxMins
