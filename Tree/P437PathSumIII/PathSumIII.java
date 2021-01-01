package Tree.P437PathSumIII;

import java.util.HashMap;
import java.util.Map;

/**
 * @CLassName PathSumIII
 * @Description
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @Author cst
 * @Date 12/28/20  2:23 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PathSumIII {
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return count;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, 0, sum, map);
        return count;
    }
    public void helper(TreeNode root, int presum, int sum, Map<Integer, Integer> map) {
        System.out.println("Now map contains " + map);

        if (root == null) {
            return;
        }
        presum += root.val;
        if (map.containsKey(presum - sum)) {
            System.out.println("Map contains presum " + presum + " and sum " + sum);
            count += map.get(presum - sum);
        }
        map.put(presum, map.getOrDefault(presum, 0) + 1);
        helper(root.left, presum, sum, map);
        helper(root.right, presum, sum, map);
        map.put(presum, map.get(presum) - 1);
        presum -= root.val;
    }
}
