package BfsAndDfs.P863AllNodesDistanceKInBinaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @CLassName AllNodesDistanceKInBinaryTree
 * @Description
 *              We are given a binary tree (with root node root), a target node, and an integer value K.
                Return a list of the values of all nodes that have a distance K from the target node.
                The answer can be returned in any order.
            Example 1:

            Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

            Output: [7,4,1]

            Explanation:
            The nodes that are a distance 2 from the target node (with value 5)
            have values 7, 4, and 1.
                        3
                    5       1
                6    2       0   8
                    7 4
            Note that the inputs "root" and "target" are actually TreeNodes.
            The descriptions of the inputs above are just serializations of these objects.
 * @Author cst
 * @Date 12/14/20  3:51 PM
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        buildGraph(map, root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if (K == 0) {
                while(!queue.isEmpty()){
                    res.add(queue.poll().val);
                }
                return res;
            }
            for (int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                List<TreeNode> l = map.get(temp);
                for(TreeNode p : l){
                    if (visited.contains(p))
                        continue;
                    visited.add(p);
                    queue.offer(p);
                }
            }
            K--;
        }
        return res;
    }

    // build undirected graph
    public void buildGraph(Map<TreeNode, List<TreeNode>> map, TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<TreeNode>());
        }
        if (parent != null) {
            map.get(root).add(parent);
            map.get(parent).add(root);
        }
        buildGraph(map, root.left, root);
        buildGraph(map, root.right, root);
    }
}
