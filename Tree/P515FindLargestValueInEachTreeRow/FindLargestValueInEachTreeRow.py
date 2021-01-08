import unittest
from collections import deque
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        q = deque([root])
        while q:
            size = len(q)
            maxValue = q[0].val
            for _ in range(size):
                node = q.popleft()
                maxValue = max(maxValue, node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res.append(maxValue)
        return res

class UnitTest(unittest.TestCase):
    def test(self):
        n1 = TreeNode(1)
        n2 = TreeNode(3)
        n3 = TreeNode(2)
        n4 = TreeNode(5)
        n5 = TreeNode(3)
        n6 = TreeNode(9)
        n1.left = n2
        n1.right = n3
        n2.left = n4
        n2.right = n5
        n3.right = n6
        self.assertEqual([1,3,9], Solution().largestValues(n1))
if __name__ == "__main__":
    unittest.main()
                