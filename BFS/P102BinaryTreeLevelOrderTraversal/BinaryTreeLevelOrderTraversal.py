import unittest
from collections import deque
from typing import List
# Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

# For example:
# Given binary tree [3,9,20,null,null,15,7],
#     3
#    / \
#   9  20
#     /  \
#    15   7
# return its level order traversal as:
# [
#   [3],
#   [9,20],
#   [15,7]
# ]
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    
    # BFS
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return None
        else:
            res, q = [], deque([root])
            while(q):
                size, level = len(q), []
                for _ in range(size):
                    node = q.popleft()
                    level.append(node.val)
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
                res.append(level)
            return res
     # DFS
    def levelOrderDfs(self, root: TreeNode) -> List[List[int]]:
         if not root:
             return None
         else:
            res = []
            self.dfs(root, res, 0)
            return res
    
    def dfs(self, root: TreeNode, res, level):
        if not root:
            return
        if len(res) < level + 1:
            res.append([])
        res[level].append(root.val)
        self.dfs(root.left, res, level+1)
        self.dfs(root.right, res, level+1)                     
                
class UnitTest(unittest.TestCase):
    def test_1(self):
        a = TreeNode(3)
        b = TreeNode(9)
        c = TreeNode(20)
        d = TreeNode(15)
        e = TreeNode(7)
        a.left = b
        a.right = c
        c.left = d
        c.right = e
        res =[[3], [9, 20], [15, 7]]
        self.assertEqual(Solution().levelOrder(a), res)
        self.assertEqual(Solution().levelOrderDfs(a), res)

if __name__ == "__main__":
    unittest.main()