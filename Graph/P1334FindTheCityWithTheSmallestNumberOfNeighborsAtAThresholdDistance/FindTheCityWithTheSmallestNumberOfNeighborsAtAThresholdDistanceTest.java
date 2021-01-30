package Graph.P1334FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance;

import junit.framework.TestCase;

/**
 * @CLassName FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistanceTest
 * @Description TODO
 * @Author cst
 * @Date 1/27/21  2:00 PM
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistanceTest extends TestCase {
    public void testFindTheCity() {
        int n = 4;
        int[][] edges = new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        assertEquals(3, new FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance()
                                    .findTheCity(n, edges, distanceThreshold));
    }
}
