#  101. Symmetric Tree
## Recursion
- For every node, check the mirror of this node, if false, return false directly. If true, we continue to check its children's mirror until reaching the leaf node.
## Iteration
- Using queue, initial condition is to add root.left and root.right into queue.
- While queue is not empty, we just pop its first two nodes to check whether their value equals or not. If not, return false, otherwise, push the left.left and right.right, left.right, and right.left in turn

## Input & Output
- Input: TreeNode. The node tree.
- Output: Boolean. Whether the tree is symmetrical or not. 