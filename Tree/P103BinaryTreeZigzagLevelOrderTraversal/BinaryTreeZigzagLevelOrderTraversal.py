import unittest
from collections import deque
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res, line = [], 0
        q = deque([root])
        while q:
            size = len(a)
            temp = []
            for i in range(size):
                node = q.popleft()
                temp.append(node.val) if line % 2 == 0 else temp.insert(0, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            line += 1
            res.append(temp)
        return res
              