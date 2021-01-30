package Graph.P1162AsFarFromLandAsPossible;

import junit.framework.TestCase;

/**
 * @CLassName AsFarFromLandAsPossibleTest
 * @Description TODO
 * @Author cst
 * @Date 1/29/21  12:58 PM
 */
public class AsFarFromLandAsPossibleTest extends TestCase {
    public void testMaxDistance() {
        int[][] grid = new int[][]{{1, 0, 0, 0, 0, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1}, {0, 0, 0, 1, 1, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 1, 1, 1, 1, 0, 0}};
        assertEquals(2, new AsFarFromLandAsPossible().maxDistance(grid));

    }
}
