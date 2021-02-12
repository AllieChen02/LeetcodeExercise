package Graph.P1631PathWithMinimumEffort;

import junit.framework.TestCase;

/**
 * @CLassName PathWithMinimumEffortTest
 * @Description TODO
 * @Author cst
 * @Date 2/5/21  2:51 PM
 */
public class PathWithMinimumEffortTest extends TestCase {
    public void testMinimumEffortPath() {
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        assertEquals(2, new PathWithMinimumEffort().minimumEffortPath(heights));
    }
}
