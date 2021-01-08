package Tree.P450DeleteNodeInABST;


/**
 * @CLassName DeleteNodeInABST
 * @Description
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 10
 *
 * @Author cst
 * @Date 1/4/21  2:57 PM
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // go left branch
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            // go right branch
            root.right = deleteNode(root.right, key);
        } else {

            // case 1: have no children
            if (root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                // case 2: only have right child
                return root.right;
            } else if(root.right == null) {
                // case 3: only have left child
                return root.left;
            } else {
                // case 4: have left and right child
                TreeNode min = findMinimum(root.right);
                // replace its location
                root.val = min.val;
                // delete min node
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    private TreeNode findMinimum(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
