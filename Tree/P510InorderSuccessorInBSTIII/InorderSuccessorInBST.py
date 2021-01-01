import unittest

# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

class Solution:
    def inorderSuccessor(self, node: 'Node') -> 'Node':
        # if there exists right branches, the successor of node would be the most left node in right branches
        if node.right:
            node = node.right
            while node.left:
                node = node.left
            return node
        
        # if target node does not have right branches, we could look for its parent node
        while node.parent and node.parent.val < node.val:
            node = node.parent
        return node.parent if node else None

    