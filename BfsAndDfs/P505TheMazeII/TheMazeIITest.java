package BfsAndDfs.P505TheMazeII;

import junit.framework.TestCase;

/**
 * @CLassName TheMazeIITest
 * @Description TODO
 * @Author cst
 * @Date 1/22/21  9:04 PM
 */
public class TheMazeIITest extends TestCase {
    public void testShortestDistance() {
        int[][] inputs = new int[][]{{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{3,2};
        assertEquals(-1, new TheMazeII().shortestDistance(inputs, start, destination));

        start = new int[]{0, 4};
        destination = new int[]{4,4};
        assertEquals(12, new TheMazeII().shortestDistance(inputs, start, destination));
    }
}
