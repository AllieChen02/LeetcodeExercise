package BfsAndDfs.P1466ReorderRoutesToMakeAllPathsLeadToTheCityZero;

import junit.framework.TestCase;

/**
 * @CLassName P1466ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest
 * @Description TODO
 * @Author cst
 * @Date 1/6/21  3:06 PM
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest extends TestCase {
    public void testMinReorder() {
        int[][] connections = new int[][]{{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
        int n = 6;
        assertEquals(3, new ReorderRoutesToMakeAllPathsLeadToTheCityZero().minReorder(n, connections));

        connections = new int[][]{{1,0}, {1,2}, {3,2}, {3,4}};
        n = 2;
        assertEquals(2, new ReorderRoutesToMakeAllPathsLeadToTheCityZero().minReorder(n, connections));
    }
}
