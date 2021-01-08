package Tree.P1448CountGoodNodesInBinaryTree;

/**
 * @CLassName CountGoodNodesInBinaryTree
 * @Description
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 * @Author cst
 * @Date 1/6/21  4:52 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
    }
}

public class CountGoodNodesInBinaryTree {
    private int res = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, root.val);
        return res;
    }

    // DFS, when the current node is greater than this path maximum value, it indicates that
    // this node is good.
    public void dfs(TreeNode root, int maxValue) {
        if (root == null) {
            return;
        }
        if (root.val >= maxValue) {
            res += 1;
        }
        maxValue = Math.max(maxValue, root.val);
        dfs(root.left, maxValue);
        dfs(root.right, maxValue);
    }
}

