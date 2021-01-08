package Tree.P1448CountGoodNodesInBinaryTree;

import junit.framework.TestCase;

/**
 * @CLassName CountGoodNodesInBinaryTreeTest
 * @Description TODO
 * @Author cst
 * @Date 1/6/21  4:52 PM
 */
public class CountGoodNodesInBinaryTreeTest extends TestCase {
    public void testGoodNodes() {
        TreeNode n1, n2, n3, n4, n5, n6;
        n1 = new TreeNode(3);
        n2 = new TreeNode(1);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(1);
        n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n4.left = n5;
        n4.right = n6;
        assertEquals(4, new CountGoodNodesInBinaryTree().goodNodes(n1));
    }

}
