package DP.P63UniquePathsII;

import junit.framework.TestCase;

/**
 * @CLassName UniquePathsIITest
 * @Description TODO
 * @Author cst
 * @Date 1/8/21  3:15 PM
 */
public class UniquePathsIITest extends TestCase {
    public void testUniquePathsWithObstacles() {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(2, new UniquePathsII().uniquePathsWithObstacles(arr));
    }
}
