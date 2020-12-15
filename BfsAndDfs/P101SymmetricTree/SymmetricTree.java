package BfsAndDfs.P101SymmetricTree;
import java.util.LinkedList;
import java.util.Queue;

/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    // recursive
    public boolean isSymmetricRecursive(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if(left != null && right != null) {
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        } else if(right == null && left == null) {
            return true;
        } else {
            return false;
        }
    }

    // iterative
    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null) {
                continue;
            } else if(left == null || right == null) {
                return false;
            } else if(left.val != right.val) {
                return false;
            } else {
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
        }
        return true;
    }
}
