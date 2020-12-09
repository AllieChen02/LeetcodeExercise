package BFS.P111MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its minimum depth:
// 2
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
public class MinimumDepthOfBinaryTree {
    private int res = Integer.MAX_VALUE;
    // DFS
    public int minDepthDFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, 1);
        return res;
    }
    public void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            res = Math.min(depth, res);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth+1);
        }
        if (root.right != null) {
            dfs(root.right, depth+1);
        }
    }


    // BFS
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return res;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res++;
        }
        return res;
    }
}
