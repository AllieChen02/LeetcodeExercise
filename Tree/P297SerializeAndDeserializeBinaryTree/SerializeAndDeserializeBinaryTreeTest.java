package Tree.P297SerializeAndDeserializeBinaryTree;

import junit.framework.TestCase;

/**
 * @CLassName SerializeAndDeserializeBinaryTreeTest
 * @Description TODO
 * @Author cst
 * @Date 1/3/21  3:13 PM
 */
public class SerializeAndDeserializeBinaryTreeTest extends TestCase {
    public void testMethod() {
        TreeNode n1, n2, n3, n4, n5;
        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        SerializeAndDeserializeBinaryTree sb = new SerializeAndDeserializeBinaryTree();
        assertEquals(n1.val, sb.deserialize(sb.serialize(n1)).val);
    }
}
