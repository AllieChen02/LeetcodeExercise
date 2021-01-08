# 450. Delete Node In A BST
## Method
    
    - Find the target node, if not exists, then return root
    - If we find target node:
        -  If it does not have left and right children, then directly delet it
        -  If it only has left child, then return its right branch
        -  If it only has right child, then return its left branch
        -  If it has left and right children , find the minimum node in right branch and put it in the target location
        
## Time complexity
    O(logN). We go down the tree all the time to first search the node
## Space Complexity
    O(H) to keep the recursion stack