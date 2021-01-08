package DP.P62UniquePaths;

import junit.framework.TestCase;

/**
 * @CLassName UniquePathsTest
 * @Description TODO
 * @Author cst
 * @Date 1/8/21  3:09 PM
 */
public class UniquePathsTest extends TestCase {
    public void testUniquePaths() {
        int m = 3, n = 7;
        assertEquals(28, new UniquePaths().uniquePaths(m, n));
        
        m = 3;
        n = 2;
        assertEquals(3, new UniquePaths().uniquePaths(m, n));
    }
}
