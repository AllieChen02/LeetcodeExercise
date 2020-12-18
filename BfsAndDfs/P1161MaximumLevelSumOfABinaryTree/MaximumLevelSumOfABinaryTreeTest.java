package BfsAndDfs.P1161MaximumLevelSumOfABinaryTree;

import junit.framework.TestCase;

/**
 * @CLassName MaximumLevelSumOfABinaryTreeTest
 * @Description TODO
 * @Author cst
 * @Date 12/15/20  1:07 PM
 */

public class MaximumLevelSumOfABinaryTreeTest extends TestCase {
    public void testMaxLevelSum() {
        TreeNode n1, n2,n3, n4, n5;
        n1 = new TreeNode(1);
        n2 = new TreeNode(7);
        n3 = new TreeNode(0);
        n4 = new TreeNode(7);
        n5 = new TreeNode(-8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        assertEquals(2, new MaximumLevelSumOfABinaryTree().maxLevelSumBFS(n1));
        assertEquals(2, new MaximumLevelSumOfABinaryTree().maxLevelSumDFS(n1));


        n1 = new TreeNode(989);
        n2 = new TreeNode(10250);
        n3 = new TreeNode(98693);
        n4 = new TreeNode(-89388);
        n5 = new TreeNode(-32127);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n4.right = n5;
        assertEquals(2, new MaximumLevelSumOfABinaryTree().maxLevelSumBFS(n1));
        assertEquals(2, new MaximumLevelSumOfABinaryTree().maxLevelSumDFS(n1));
    }
}
