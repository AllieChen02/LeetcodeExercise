import unittest
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        elif not root.left and not root.right:
            return 1
        elif root.left and not root.right:
            return 1 + self.minDepth(root.left)
        elif not root.left and root.right:
            return 1 + self.minDepth(root.right)
        else:
            return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
        
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
        self.assertEqual(Solution().minDepth(a), 2)

if __name__ == "__main__":
    unittest.main()