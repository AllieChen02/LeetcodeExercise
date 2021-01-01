import unittest

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        def helper(root, map, presum, sum):
            nonlocal count
            if not root:
                return
            presum += root.val
            if presum - sum in map:
                count += map[presum - sum]
            if presum in map:
                map[presum] += 1
            else:
                map[presum] = 1
            helper(root.left, map, presum, sum)
            helper(root.right, map, presum, sum)
            map[presum] -= 1  
            
        if not root:
            return 0
        map = {}
        map[0] = 1
        count = 0
        helper(root, map, 0, sum)
        return count
        
 

class UnitTest(unittest.TestCase):
    def test_1(self):
        n1 = TreeNode(10)
        n2 = TreeNode(5)
        n3 = TreeNode(-3)
        n4 = TreeNode(3)
        n5 = TreeNode(2)
        n6 = TreeNode(11)
        n7 = TreeNode(3)
        n8 = TreeNode(-2)
        n9 = TreeNode(1)
        n1.left = n2
        n1.right = n3
        n2.left = n4
        n2.right = n5
        n3.right = n6
        n4.left = n7
        n4.right = n8
        n5.right = n9
        sum = 8
        self.assertEquals(3,  Solution().pathSum(n1, sum))

if __name__ == "__main__":
    unittest.main()     