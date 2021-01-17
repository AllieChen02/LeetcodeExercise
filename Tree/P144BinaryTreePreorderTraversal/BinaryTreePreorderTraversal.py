import unittest
from collections import List



class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    # recursion
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        self.res = []
        if not root:
            return self.res
        def helper(root):
            if not root:
                return
            self.res.append(root.val)
            helper(root.left)
            helper(root.right)
        helper(root)
        return self.res

    # iterative, using stack
    def preorderTraversal_1(self, root: TreeNode) -> List[int]:
        res, stack = [], [root]
        if not root:
            return res
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.right is not None:
                stack.append(node.right)
            if node.left is not None:
                stack.append(node.left)
        return res