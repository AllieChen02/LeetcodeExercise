package BfsAndDfs.P111MinimumDepthOfBinaryTree;
import junit.framework.TestCase;

public class MinimumDepthOfBinaryTreeTest extends TestCase {
    public void testMinDepthDFS() {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        assertEquals(new MinimumDepthOfBinaryTree().minDepthDFS(a) ,2);
        assertEquals(new MinimumDepthOfBinaryTree().minDepthBFS(a) ,2);

        a = new TreeNode(2);
        b = new TreeNode(3);
        c = new TreeNode(4);
        d = new TreeNode(5);
        e = new TreeNode(6);
        a.right = b;
        b.right = c;
        c.right = d;
        d.right = e;
        assertEquals(new MinimumDepthOfBinaryTree().minDepthDFS(a) ,5);
        assertEquals(new MinimumDepthOfBinaryTree().minDepthBFS(a) ,5);
    }
}
