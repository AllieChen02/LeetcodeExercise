package BfsAndDfs.P1293ShortestPathInAGridWithoutObstaclesElimination;

import junit.framework.TestCase;

public class ShortestPathInAGridWithObstaclesEliminationTest extends TestCase {
    public void testShortestPath() {
        int[][] grid = {{0,0,0}, {1,1,0}, {0,0,0}, {0,1,1}, {0,0,0}};
        int k = 1;
        assertEquals(6, new ShortestPathInAGridWithObstaclesElimination().shortestPath(grid, k));

        grid = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
        assertEquals(-1, new ShortestPathInAGridWithObstaclesElimination().shortestPath(grid, k));
    }
}
