package BFS.P102BinaryTreeLevelOrderTraversal;
import java.util.*;
import java.util.stream.Collectors;
import junit.framework.TestCase;

public class BinaryTreeLevelOrderTraversalTest extends TestCase{
    public void testIsSymmetricRecursive() {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l1 = Arrays.stream(new int[]{3}).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(new int[]{9, 20}).boxed().collect(Collectors.toList());
        List<Integer> l3 = Arrays.stream(new int[]{15, 7}).boxed().collect(Collectors.toList());
        res.add(l1);
        res.add(l2);
        res.add(l3);
        assertEquals(new BinaryTreeLevelOrderTraversal().levelOrder(a), res);

    }
}
