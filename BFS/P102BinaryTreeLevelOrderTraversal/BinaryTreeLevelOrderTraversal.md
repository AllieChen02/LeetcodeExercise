#  102. Binary Tree Order Traversal
Data structure: 

    - Queue

Important variables: 

    - Level List
    For each level, firstly we should declare the size of this  level and then traversal all nodes in this level. For each node, when adding to level list, we should also pay attention to its left and right children. If they are not null, we should push them into queue, which will be popped in next level traversal. 

    - Return List
    When finishing each level traversal, we could add level list into return list.

    - Queue:
    Queue is the important data structure in BFS problems. It makes sure that node is stored in the right order. 