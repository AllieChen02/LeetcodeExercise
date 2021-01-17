package Tree.P103BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @CLassName BinaryTreeZigzagLevelOrderTraversal
 * @Description TODO
 * @Author cst
 * @Date 1/12/21  3:18 PM
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(flag){
                    list.add(curr.val);
                }else{
                    list.add(0, curr.val);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
