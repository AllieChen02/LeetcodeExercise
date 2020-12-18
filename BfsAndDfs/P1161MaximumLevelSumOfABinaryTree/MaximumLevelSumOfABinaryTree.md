# 1161. Maximum Level Sum Of A Binary Tree
## BFS
    - Traverse the binary tree in level order method. using a parameter to record the sum of all nodes in one level and compare it with the global parameter. If greater, then replace result with this level.
    - Time Complexity: Since we have to visit all nodes of a binary tree once, the average time complexity is O(N)
    - Space Complexity: O(N) to keep the queue
## DFS
    - Implement recursive i norder traversal. Create a function inorder(node, level) which takes node and its level as input variables and recursively updates level_sum[level] structure.

    - Return key with max value in level_sum
    - Time Complexity: O(N), to visit each node exactly once during the inorder traversal
    - Space Complexity: O(1) since we are using a size = 10000 array to record all level sum. 