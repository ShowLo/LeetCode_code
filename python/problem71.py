class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stack = []
        pathLen = len(path)
        index = 0
        while index < pathLen:
            while index < pathLen and path[index] == '/':
                index += 1
            s = ''
            while index < pathLen and path[index] != '/':
                s += path[index]
                index += 1
            if s == '..':
                if len(stack) != 0:
                    stack.pop()
            elif s != '.' and s != '':
                stack.append(s)
        return '/' + '/'.join(stack)