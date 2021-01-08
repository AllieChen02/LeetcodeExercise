import unittest
from collections import deque

'''
Given a binary tree, return the sum of values of its deepest leaves.
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def deepestLeavesSum(self, root: TreeNode) -> int:
        res = 0
        if not root:
            return res
        # BFS
        queue = deque([root])
        while queue:
            size = len(queue)
            res = 0
            for _ in range(size):
                curr = queue.popleft()
                res += curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
        return res
    
class UnitTest(unittest.TestCase):
    def test(self):
        n1 = TreeNode(1)
        n2 = TreeNode(2)
        n3 = TreeNode(3)
        n4 = TreeNode(4)
        n5 = TreeNode(5)
        n6 = TreeNode(6)
        n1.left = n2
        n1.right = n3
        n2.left = n4
        n2.right = n5
        n3.right = n6
        self.assertEqual(15, Solution().deepestLeavesSum(n1))
        

if __name__ == "__main__":
    unittest.main()
            
                