package Heap.P1439FindTheKthSmallestSumofAMatrixWithSort;

import junit.framework.TestCase;

/**
 * @CLassName FindTheKthSmallestSumofAMatrixWithSortTest
 * @Description TODO
 * @Author cst
 * @Date 1/21/21  12:24 PM
 */
public class FindTheKthSmallestSumofAMatrixWithSortTest extends TestCase {
    public void testKthSmallest() {
        int[][] mat = new int[][]{{1,3,11},{2,4,6}};
        int k = 5;
        assertEquals(7, new FindTheKthSmallestSumofAMatrixWithSort().kthSmallest(mat, k));
    }
}
