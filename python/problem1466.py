class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        toNext = collections.defaultdict(list)
        reverse = collections.defaultdict(list)
        visited = [False] * n
        for con in connections:
            toNext[con[0]].append(con[1])
            reverse[con[1]].append(con[0])
        queue = collections.deque()
        queue.append(0)
        visited[0] = True
        result = 0
        while len(queue) > 0:
            node = queue.popleft()
            for nextNode in reverse[node]:
                if not visited[nextNode]:
                    visited[nextNode] = True
                    queue.append(nextNode)
            for nextNode in toNext[node]:
                if not visited[nextNode]:
                    visited[nextNode] = True
                    queue.append(nextNode)
                    result += 1
        return result
