package Graph.P310MinimumHeightTrees;

import junit.framework.TestCase;

import java.util.List;

/**
 * @CLassName MinimumHeightTreesTest
 * @Description TODO
 * @Author cst
 * @Date 1/27/21  10:19 PM
 */
public class MinimumHeightTreesTest extends TestCase {
    public void testFindMinHeightTrees() {
        int n = 6;
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> res = new MinimumHeightTrees().findMinHeightTrees(n, edges);
        assertEquals(3, (int)res.get(0));
        assertEquals(4, (int)res.get(1));
    }
}
