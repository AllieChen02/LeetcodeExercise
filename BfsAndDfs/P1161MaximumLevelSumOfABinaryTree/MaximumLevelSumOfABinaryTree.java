package BfsAndDfs.P1161MaximumLevelSumOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @CLassName MaximumLevelSumOfABinaryTreeTest
 * @Description
 *              Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *              Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *                  1
 *               7     0
 *              7 -8
 *              Input: root = [1,7,0,7,-8,null,null]
 *              Output: 2
 *              Explanation:
 *              Level 1 sum = 1.
 *              Level 2 sum = 7 + 0 = 7.
 *              Level 3 sum = 7 + -8 = -1.
 *              So we return the level with the maximum sum which is level 2.
 *
 *              The number of nodes in the tree is in the range [1, 104].
 *              -105 <= Node.val <= 105
 * @Author cst
 * @Date 12/15/20  1:06 PM
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

public class MaximumLevelSumOfABinaryTree {
    // BFS
    public int maxLevelSumBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0, level = 0;
        int max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (levelSum > max) {
                res = level;
                max = levelSum;
            }
            level++;
        }
        return res+1;
    }


    // DFS
    int[] levelSum = new int[10000];
    public int maxLevelSumDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // inOrder
        inOrder(root, 1);

        int res = 0;
        for (int i=0; i<levelSum.length; i++) {
            res = levelSum[i] > levelSum[res] ? i : res;
        }
        return res;
    }
    public void inOrder(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        inOrder(node.left, level+1);
        levelSum[level] += node.val;
        inOrder(node.right, level + 1);
    }
}
