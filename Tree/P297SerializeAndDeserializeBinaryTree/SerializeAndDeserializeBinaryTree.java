package Tree.P297SerializeAndDeserializeBinaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @CLassName SerializeAndDeserializeBinaryTree
 * @Description TODO
 * @Author cst
 * @Date 1/3/21  3:00 PM
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class SerializeAndDeserializeBinaryTree {
    private String comma = ",";
    private String invalid = "NULL";

    public String serialize(TreeNode root) {
        // level order
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    res.append(invalid).append(comma);
                } else {
                    res.append(curr.val).append(comma);
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
        }
        return res.toString();
    }
    // string: [1,2,3,NULL,5]
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0){
            return null;
        }
        String[] strs = data.split(comma);
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // for each node, we need to define its right child and left child, regardless null or not
            if (!strs[idx].equals(invalid)) {
                TreeNode node = new TreeNode(Integer.parseInt(strs[idx]));
                curr.left = node;
                queue.offer(node);
            }
            if(!strs[++idx].equals(invalid)){
                TreeNode node = new TreeNode(Integer.parseInt(strs[idx]));
                curr.right = node;
                queue.offer(node);
            }
            idx++;
        }
        return root;
    }
}
