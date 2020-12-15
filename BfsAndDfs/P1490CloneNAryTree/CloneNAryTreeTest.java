package BfsAndDfs.P1490CloneNAryTree;

import junit.framework.TestCase;

import java.util.*;

/**
 * @CLassName CloneNAryTreeTest
 * @Description TODO
 * @Author cst
 * @Date 12/12/20  2:12 PM
 */

public class CloneNAryTreeTest extends TestCase {
    public void testCloneTreeBFS() {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        n1.children.add(n4);
        n1.children.add(n5);

        Node cloneRoot = new CloneNAryTree().cloneTreeBFS(root);
        // because their address is different, so we could only verify their values
        assertEquals("check their root val", root.val, cloneRoot.val);

        List<Node> children = cloneRoot.children;
        assertEquals("check their second level", n1.val, children.get(0).val);
        assertEquals("check their second level", n2.val, children.get(1).val);
        assertEquals("check their second level", n3.val, children.get(2).val);

        List<Node> grandchildren = children.get(0).children;
        assertEquals("check their third level", n4.val, grandchildren.get(0).val);
        assertEquals("check their third level", n5.val, grandchildren.get(1).val);

    }

    public void testCloneTreeDFS() {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        n1.children.add(n4);
        n1.children.add(n5);

        Node cloneRoot = new CloneNAryTree().cloneTreeDFS(root);
        // because their address is different, so we could only verify their values
        assertEquals("check their root val", root.val, cloneRoot.val);

        List<Node> children = cloneRoot.children;
        assertEquals("check their second level", n1.val, children.get(0).val);
        assertEquals("check their second level", n2.val, children.get(1).val);
        assertEquals("check their second level", n3.val, children.get(2).val);

        List<Node> grandchildren = children.get(0).children;
        assertEquals("check their third level", n4.val, grandchildren.get(0).val);
        assertEquals("check their third level", n5.val, grandchildren.get(1).val);

    }
}
