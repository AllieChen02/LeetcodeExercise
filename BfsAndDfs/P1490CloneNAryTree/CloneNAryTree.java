package BfsAndDfs.P1490CloneNAryTree;

import java.util.*;

/**
 * @CLassName CloneNAryTree
 * @Description
     Given a root of an N-ary tree, return a deep copy (clone) of the tree.
     Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.
     class Node {
        public int val;
        public List<Node> children;
     }
     Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
            1
        3   2   4
       5 6
     Input: root = [1,null,3,2,4,null,5,6]
     Output: [1,null,3,2,4,null,5,6]
 * @Author cst
 * @Date 12/12/20  2:12 PM
 */
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class CloneNAryTree {

    // BFS
    public Node cloneTreeBFS(Node root) {
        // edge case
        if (root == null) {
            return null;
        }
        // key: old node;    value: after cloning node
        Map<Node, Node> map = new HashMap<>();
        map.put(root, new Node(root.val));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node curr = queue.poll();
                for (Node child : curr.children) {
                    if (!map.containsKey(child)) {
                        map.put(child, new Node(child.val));
                        queue.offer(child);
                    }
                    // after cloning, we have to re-construct their relationship (parent - children node)
                    map.get(curr).children.add(map.get(child));
                }
            }
        }
        return map.get(root);
    }


    // DFS
    public Node cloneTreeDFS(Node root) {
        if (root == null) {
            return null;
        }
        Node cloneNode = new Node(root.val);
        for (Node child : root.children) {
            cloneNode.children.add(cloneTreeDFS(child));
        }
        return cloneNode;
    }
}
