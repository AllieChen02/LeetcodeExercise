# 863.All Nodes Distance K In Binary Tree

## BFS - using Hashmap
- For one node, the distance for target node could be its children or parents. So we could consider to build a undirected graph, using TreeNodes as vertices, and the parent-child relation as edges. 
- To Build graph, we could use Map<TreeNode, List<TreeNode>. Key is the node itself, and value is all vertices connected to this node. 
- Using BFS to find all vertices with distance K to it.

## Time Complexity
Since it converts tree into a graph, visiting all noes in the tree, the time complexity could be O(N)

## Space Complexity
Same as time complexity