package BfsAndDfs.P863AllNodesDistanceKInBinaryTree;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName AllNodesDistanceKInBinaryTreeTest
 * @Description TODO
 * @Author cst
 * @Date 12/14/20  4:16 PM
 */
public class AllNodesDistanceKInBinaryTreeTest extends TestCase {
    public void testDistanceK() {
        TreeNode root = new TreeNode(3);
        TreeNode n1, n2, n3, n4, n5, n6, n7, n8;
        n1 = new TreeNode(5);
        n2 = new TreeNode(1);
        n3 = new TreeNode(6);
        n4 = new TreeNode(2);
        n5 = new TreeNode(0);
        n6 = new TreeNode(8);
        n7 = new TreeNode(7);
        n8 = new TreeNode(4);
        root.left = n1;
        root.right = n2;
        n1.left= n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;
        TreeNode target = n1;
        int K = 2;
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(7);
        expectedList.add(4);
        assertEquals(expectedList, new AllNodesDistanceKInBinaryTree().distanceK(root, target, K));
    }
}
