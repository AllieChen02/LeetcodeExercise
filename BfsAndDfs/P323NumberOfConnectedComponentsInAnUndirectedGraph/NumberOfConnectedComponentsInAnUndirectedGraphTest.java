package BfsAndDfs.P323NumberOfConnectedComponentsInAnUndirectedGraph;

import junit.framework.TestCase;

/**
 * @CLassName NumberOfConnectedComponentsInAnUndirectedGraphTest
 * @Description TODO
 * @Author cst
 * @Date 1/25/21  12:41 PM
 */
public class NumberOfConnectedComponentsInAnUndirectedGraphTest extends TestCase {
    public void testCountComponents() {
        int n = 4;
        int[][] edges = new int[][]{{2,3}, {1,2}, {1,3}};
        assertEquals(2, new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(n, edges));

        n = 5;
        edges = new int[][]{{0,1}, {1,2}, {2,3}, {3,4}};
        assertEquals(1, new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(n, edges));
    }
}
