package BfsAndDfs.P499TheMazeIII;

import junit.framework.TestCase;

/**
 * @CLassName TheMazeIIITest
 * @Description TODO
 * @Author cst
 * @Date 2/17/21  12:24 PM
 */
public class TheMazeIIITest extends TestCase {
    public void test() {
        int[][] maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        int[] ball = new int[]{4, 3};
        int[] hole = new int[]{0, 1};
        assertEquals("lul", new TheMazeIII().findShortestWay(maze, ball, hole));
    }
}
