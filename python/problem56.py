# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        num = len(intervals)
        if num <= 1:
            return intervals
        intervals.sort(key = lambda obj : obj.start)
        start = intervals[0].start
        end = intervals[0].end
        result = []
        for i in range(1, num):
            if intervals[i].start <= end:
                if end < intervals[i].end:
                    end = intervals[i].end
            else:
                result.append(Interval(start, end))
                start = intervals[i].start
                end = intervals[i].end
        result.append(Interval(start, end))
        return result