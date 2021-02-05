package Graph.P1267CountServersThatCommunicate;

import junit.framework.TestCase;

/**
 * @CLassName CountServersThatCommunicateTest
 * @Description TODO
 * @Author cst
 * @Date 1/30/21  3:32 PM
 */
public class CountServersThatCommunicateTest extends TestCase {
    public void testCountServer() {
        int[][] grid = new int[][]{{1, 0}, {0, 1}};
        assertEquals(0, CountServersThatCommunicate.getInstance().countServers(grid));

        grid = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        assertEquals(4, CountServersThatCommunicate.getInstance().countServers(grid));
    }
}
