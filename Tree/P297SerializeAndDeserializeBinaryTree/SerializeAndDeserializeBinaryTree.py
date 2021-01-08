import unittest
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    comma = ","
    invalid = "NONE"
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        res = ""
        if not root:
            return res
        q = deque([root])
        while q:
            size = len(q)
            for _ in range(size):
                temp = q.popleft()
                if not temp:
                    res += Solution().invalid
                    res += Solution().comma
                else:
                    q.append(temp.left)
                    q.append(temp.right)
                    res += str(temp.val)
                    res += Solution().comma
        return res
        
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 0:
            return None
        strs = data.split(Solution().comma)
        root = TreeNode(strs[0])
        idx = 1
        q = deque([root])
        while q:
            node = q.popleft()
            if strs[idx] != Solution().invalid:
                left = TreeNode(strs[idx])
                node.left = left
                q.append(left)
            idx += 1
            if strs[idx] != Solution().invalid:
                right = TreeNode(strs[idx])
                node.right = right
                q.append(right)
            idx += 1
        return root

class UnitTest(unittest.TestCase):
    def test_1(self):
        n1 = TreeNode(1)
        n2 = TreeNode(2)
        n3 = TreeNode(3)
        n4 = TreeNode(4)
        n5 = TreeNode(5)
        n1.left = n2
        n1.right = n3
        n3.left = n4
        n3.right = n5
        
        s = Solution()
        ans = s.deserialize(s.serialize(n1))
        
        # check if ans's value equals n1
        self.assertEqual(str(n1.val), ans.val)

if __name__ == "__main__":
    unittest.main()
            
