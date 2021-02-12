package String.P536ConstructBinaryTreeFromString;

import java.util.Stack;

/**
 * @CLassName P536ConstructBinaryTreeFromString
 * @Description TODO
 * @Author cst
 * @Date 2/8/21  2:16 PM
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
 
public class P536ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (int i = 0, j = i; i<ch.length; i++, j = i) {
            if (ch[i] == ')') {
                stack.pop();
            } else if(ch[i] >= '0' && ch[i] <= '9' || ch[i] == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i++;
                TreeNode currentNode = new TreeNode(Integer.parseInt(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = currentNode;
                    } else{
                        parent.left = currentNode;
                    }
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
