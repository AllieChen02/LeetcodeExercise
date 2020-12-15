import unittest
from collections import deque
"""
     Given a root of an N-ary tree, return a deep copy (clone) of the tree.
     Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.
     class Node {
        public int val;
        public List<Node> children;
     }
     Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
            1
        3   2   4
       5 6
     Input: root = [1,null,3,2,4,null,5,6]
     Output: [1,null,3,2,4,null,5,6]
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children if children is not None else []


class Solution:
    # DFS method - recursively
    def cloneTreeDFS(self, root: 'Node') -> 'Node':
        if not root:
            return None
        cloneRoot = Node(root.val)
        for child in root.children:
            cloneRoot.children.append(self.cloneTreeDFS(child))
        return cloneRoot
 
    
class UnitTest(unittest.TestCase):
    def test_DFS(self):
        root = Node(1)
        n1 = Node(3)
        n2 = Node(2)
        n3 = Node(4)
        root.children.append(n1)
        root.children.append(n2)
        root.children.append(n3)
        n4 = Node(5)
        n5 = Node(6)
        n1.children.append(n4)
        n1.children.append(n5)
        
        cloneRoot = Solution().cloneTreeDFS(root)
        # Since their address is different, so we could only verify their values
        self.assertEquals(root.val, cloneRoot.val)
        
        children = cloneRoot.children
        self.assertEquals(n1.val, children[0].val)
        self.assertEquals(n2.val, children[1].val)
        self.assertEquals(n3.val, children[2].val)
        
        
        grandchildren = children[0].children
        self.assertEquals(n4.val, grandchildren[0].val)
        self.assertEquals(n5.val, grandchildren[1].val)
        
if __name__ == "__main__":
    unittest.main()
    