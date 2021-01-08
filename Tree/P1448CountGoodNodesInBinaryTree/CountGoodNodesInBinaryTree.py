import unittest

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        self.res = 0
        if not root:
            return self.res
        
        def dfs(root, maxValue):
            if not root:
                return None
            if root.val >= maxValue:
                self.res += 1
            maxValue = max(maxValue, root.val)
            dfs(root.left, maxValue)
            dfs(root.right, maxValue)
        dfs(root, root.val)
        return self.res


class UnitTest(unittest.TestCase):
    def test_1(self):
        n1 = TreeNode(3)
        n2 = TreeNode(1)
        n3 = TreeNode(3)
        n4 = TreeNode(4)
        n5 = TreeNode(1)
        n6 = TreeNode(5)
        n1.left = n2
        n1.right = n4
        n2.left = n3
        n4.left = n5
        n4.right = n6
        self.assertEqual(4,  Solution().goodNodes(n1))
if __name__ == "__main__":
    unittest.main()