import unittest
from collections import deque

# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3

# But the following [1,2,2,null,3,null,3] is not:

#     1
#    / \
#   2   2
#    \   \
#    3    3
 

# Follow up: Solve it both recursively and iteratively.
 
# definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # recursive
    def isSymmetric_1(self, root: TreeNode) -> bool:
        if root:
            return self.helper_1(root.left, root.right)
        else:
            return True

    def helper_1(self, left, right) -> bool:
        if not left and not right:
            return True
        elif not left or not right:
            return False
        else:
            return left.val == right.val and self.helper_1(left.left, right.right) and self.helper_1(left.right, right.left)


    # iterative
    def isSymmetric_2(self, root: TreeNode) -> bool:
        q = deque([])
        if not root:
            return True
        elif root.left and root.right:
            q.append(root.left)
            q.append(root.right)
        elif not root.left and not root.right:
            return True
        else:
            return False

        while(q):
            left = q.popleft()
            right = q.popleft()
            if not left and not right:
                continue
            elif not left or not right:
                return False
            elif left.val != right.val:
                return False
            else:
                q.append(left.left)
                q.append(right.right)
                q.append(left.right)
                q.append(right.left) 
        return True    


class UnitTest(unittest.TestCase):
    def test_1(self):
        a = TreeNode(1)
        b = TreeNode(2)
        c = TreeNode(2)
        d = TreeNode(3)
        e = TreeNode(4)
        f = TreeNode(4)
        g = TreeNode(3)
        a.left = b
        a.right = c
        b.left = d
        b.right = e
        c.left = f
        c.right = g
        self.assertEqual(Solution().isSymmetric_1(a), True)
        self.assertEqual(Solution().isSymmetric_2(a), True)

    def test_2(self):
        a = TreeNode(1)
        b = TreeNode(2)
        c = TreeNode(2)
        d = TreeNode(3)
        e = TreeNode(3)
        a.left = b
        a.right = c
        b.left = None
        b.right = d
        c.left = None
        c.right = e
        self.assertEqual(Solution().isSymmetric_1(a), False)
        self.assertEqual(Solution().isSymmetric_2(a), False)

if __name__ == "__main__":
    unittest.main()