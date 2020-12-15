import unittest
from collections import deque, defaultdict 
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]: 
        map = defaultdict(list)
        res, visited, queue = [], set([target]), deque([target])
        self.connect(root, None, map) 
        # BFS
        while queue:
            size = len(queue)
            if K == 0:
                while(queue):
                    res.append(queue.popleft().val)
                return res
            for _ in range(size):
                temp = queue.popleft()
                for node in map[temp]:
                    if node not in visited:
                        queue.append(node) 
                        visited.add(node)                  
            K = K - 1
        return res   
                        
    # convert tree into a undirected graph
    def connect(self, child, parent, map):
        if parent:
            map[parent].append(child)
            map[child].append(parent)
        if child.left:
            self.connect(child.left, child, map)
        if child.right:
            self.connect(child.right, child, map)
                
    
    
class UnitTest(unittest.TestCase):
    def test_1(self):
        root = TreeNode(3)
        n1 = TreeNode(5)
        n2 = TreeNode(1)
        n3 = TreeNode(6)
        n4 = TreeNode(2)
        n5 = TreeNode(0)
        n6 = TreeNode(8)
        n7 = TreeNode(7)
        n8 = TreeNode(4)
        root.left = n1
        root.right = n2
        n1.left= n3
        n1.right = n4
        n2.left = n5
        n2.right = n6
        n4.left = n7
        n4.right = n8
        target = n1
        K = 2
        self.assertEqual([1, 7, 4], Solution().distanceK(root, target, K))
        
        
if __name__ == "__main__":
    unittest.main()