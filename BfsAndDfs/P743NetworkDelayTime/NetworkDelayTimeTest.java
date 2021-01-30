package BfsAndDfs.P743NetworkDelayTime;

import junit.framework.TestCase;

/**
 * @CLassName NetworkDelayTimeTest
 * @Description TODO
 * @Author cst
 * @Date 1/24/21  3:37 PM
 */
public class NetworkDelayTimeTest extends TestCase {
    public void testNetworkDelayTime() {
        int[][] times = new int[][]{{2,1,1}, {2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        assertEquals(2, new NetworkDelayTime().networkDelayTime(times, n, k));

        times = new int[][]{{1,2,1}};
        n = 2;
        k = 2;
        assertEquals(-1, new NetworkDelayTime().networkDelayTime(times, n, k));
    }
}
