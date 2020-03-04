# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pushLeft(self, leftNode, leftNodeStack):
        while leftNode.left is not None:                    #将所有左节点入栈
            leftNodeStack.append(leftNode)
            leftNode = leftNode.left
        return leftNode
    
    def pushRight(self, rightNode, rightNodeStack):
        while rightNode.right is not None:                  #将所有右节点入栈
            rightNodeStack.append(rightNode)
            rightNode = rightNode.right
        return rightNode
    
    def findTarget(self, root: TreeNode, k: int) -> bool:
        leftNodeStack, rightNodeStack = [], []
        leftNode = self.pushLeft(root, leftNodeStack)
        rightNode = self.pushRight(root, rightNodeStack)
        while leftNode is not rightNode:
            sum2num = leftNode.val + rightNode.val
            if sum2num == k:                                #找到符合条件的两个节点
                return True
            elif sum2num <  k:                              #两数之和小于target，需要增大左节点
                if leftNode.right is not None:              #当前节点右节点不为空的情况将其左节点全部入栈
                    leftNode = self.pushLeft(leftNode.right, leftNodeStack)
                else:                                       #当前节点右节点为空的情况弹出当前节点的父节点
                    leftNode = leftNodeStack.pop()
            else:                                           #两数之和大于target，需要减小右节点
                if rightNode.left is not None:              #当前节点左节点不为空的情况将其右节点全部入栈
                    rightNode = self.pushRight(rightNode.left, rightNodeStack)
                else:                                       #当前节点左节点为空的情况弹出当前节点的父节点
                    rightNode = rightNodeStack.pop()
        return False
