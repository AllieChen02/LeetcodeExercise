import unittest

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# quote from: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496549/JavaC%2B%2BPython-Easy-and-Concise        
class Solution:
    def maxProduct(self, root: TreeNode) -> int:
        self.res = 0 # global param
        total = 0
        # getSum(TreeNode root) is to get the sum of a sub tree.
        def getSum(root):
            if not root: return 0
            leftSum = getSum(root.left)
            rightSum = getSum(root.right)
            self.res = max(self.res, leftSum * (total - leftSum), rightSum * (total - rightSum))
            return leftSum + rightSum + root.val
        total = getSum(root)
        getSum(root)
        return self.res % (10**9 + 7)

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
        n3.left = n6
        self.assertEqual(110, Solution().maxProduct(n1))

if __name__ == "__main__":
    unittest.main()