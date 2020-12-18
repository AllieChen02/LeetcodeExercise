import unittest
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution():
    # BFS
    def maxLevelSum(self, root: TreeNode) -> int:
        if not root:
            return 0
        q, res, maxSum = deque([(root, 0)]), 0, root.val
        while q:
            size = len(q)
            sum = 0
            for _ in range(size):
                node, level = q.popleft()
                sum += node.val
                if node.left:
                    q.append((node.left, level+1))
                if node.right:
                    q.append((node.right, level+1))
            if sum > maxSum:
                res = level 
                maxSum = sum
        return res+1
    
class UnitTest(unittest.TestCase):
    def test_1(self):
        n1 = TreeNode(1)
        n2 = TreeNode(7)
        n3 = TreeNode(0)
        n4 = TreeNode(7)
        n5 = TreeNode(-8)
        n1.left = n2
        n1.right = n3
        n2.left = n4
        n2.right = n5
        self.assertEqual(2, Solution().maxLevelSum(n1))

if __name__ == "__main__":
    unittest.main()   
