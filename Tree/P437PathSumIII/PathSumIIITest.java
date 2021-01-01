package Tree.P437PathSumIII;

import junit.framework.TestCase;

/**
 * @CLassName PathSumIIITest
 * @Description TODO
 * @Author cst
 * @Date 12/28/20  2:46 PM
 */
public class PathSumIIITest extends TestCase {
    public void testPathSum() {
        TreeNode n1, n2, n3, n4, n5, n6,n7, n8, n9;
        n1 = new TreeNode(10);
        n2 = new TreeNode(5);
        n3 = new TreeNode(-3);
        n4 = new TreeNode(3);
        n5 = new TreeNode(2);
        n6 = new TreeNode(11);
        n7 = new TreeNode(3);
        n8 = new TreeNode(-2);
        n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
        int sum = 8;
        assertEquals(3, new PathSumIII().pathSum(n1, sum));
    }

    public void testPathSum2() {
        TreeNode n1, n2, n3, n4, n5, n6,n7, n8, n9, n10;
        n1 = new TreeNode(5);
        n2 = new TreeNode(4);
        n3 = new TreeNode(8);
        n4 = new TreeNode(11);
        n5 = new TreeNode(13);
        n6 = new TreeNode(4);
        n7 = new TreeNode(7);
        n8 = new TreeNode(2);
        n9 = new TreeNode(5);
        n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.left = n9;
        n5.right= n10;
        int sum = 22;
        assertEquals(3, new PathSumIII().pathSum(n1, sum));
    }
}
