# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        result = []
        num = len(intervals)
        if num == 0:
            return [newInterval]
        if newInterval.end < intervals[0].start:
            intervals.insert(0, newInterval)
            return intervals
        if newInterval.start > intervals[-1].end:
            intervals.append(newInterval)
            return intervals
        insertStart = 0
        insertEnd = 0
        for i in range(num):
            start = intervals[i].start
            end = intervals[i].end
            if newInterval.start >= start and newInterval.start <= end:
                insertStart = i
                break
            elif newInterval.start < start:
                insertStart = i - 0.5
                break
        for j in range(i, num):
            start = intervals[j].start
            end = intervals[j].end
            if newInterval.end >= start and newInterval.end <= end:
                insertEnd = j
                break
            elif newInterval.end < start:
                insertEnd = j - 0.5
                break
            elif j == num - 1:
                insertEnd = j + 0.5
        if insertStart == insertEnd:
            if insertStart % 1 == 0:
                return intervals
            else:
                intervals.insert(int(insertStart + 0.5), newInterval)
                return intervals
        if insertStart % 1 == 0:
            if insertEnd % 1 == 0:
                newEnd = intervals[insertEnd].end
                for k in range(insertEnd, insertStart, -1):
                    intervals.pop(k)
                intervals[insertStart].end = newEnd
            else:
                newEnd = newInterval.end
                for k in range(int(insertEnd - 0.5), insertStart, -1):
                    intervals.pop(k)
                intervals[insertStart].end = newEnd
        else:
            if insertEnd % 1 == 0:
                newEnd = intervals[insertEnd].end
                for k in range(insertEnd, int(insertStart + 0.5), -1):
                    intervals.pop(k)
                intervals[int(insertStart + 0.5)].end = newEnd
                intervals[int(insertStart + 0.5)].start = newInterval.start
            else:
                for k in range(int(insertEnd - 0.5), int(insertStart + 0.5), -1):
                    intervals.pop(k)
                intervals[int(insertStart + 0.5)].start = newInterval.start
                intervals[int(insertStart + 0.5)].end = newInterval.end
        return intervals