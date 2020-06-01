# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return '[]'
        res = []
        queue = collections.deque()
        nodeCount = 1
        queue.append(root)
        while nodeCount > 0:
            node = queue.popleft()
            if not node:
                res.append('None')
            else:
                nodeCount -= 1
                res.append(str(node.val))
                queue.append(node.left)
                if node.left:
                    nodeCount += 1
                queue.append(node.right)
                if node.right:
                    nodeCount += 1 
        return ','.join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == '[]':
            return None
        datas = data.split(',')
        n = len(datas)
        queue = collections.deque()
        root = TreeNode(eval(datas[0]))
        queue.append(root)
        idx = 1
        while idx < n:
            node = queue.popleft()
            if eval(datas[idx]) is not None:
                node.left = TreeNode(eval(datas[idx]))
                queue.append(node.left)
            idx += 1
            if idx < n and eval(datas[idx]) is not None:
                node.right = TreeNode(eval(datas[idx]))
                queue.append(node.right)
            idx += 1
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
