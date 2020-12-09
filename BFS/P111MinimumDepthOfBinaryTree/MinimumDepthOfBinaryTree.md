#  111. Minimum Depth of Binary Tree
## DFS
    - Using a global parameter to record the minimum depth

    - Traverse each path until leaf node, and compare the depth with the global one. If smaller, replace it. 

    - Time complexity
    DFS visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.

    - Space complexity
    In the worst case, the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree would be O(log(N)). 

## BFS
    - Using a queue for BFS
    - When the pop node does not have left child and right child, return this level directly.

    - Time complexity 
    In the worst case for a balanced tree we need to visit all nodes level by level up to the tree height, that excludes the bottom level only. Thus the time complexity is O(N).

    - Space complexity
    Is the same as time complexity here O(N) 


