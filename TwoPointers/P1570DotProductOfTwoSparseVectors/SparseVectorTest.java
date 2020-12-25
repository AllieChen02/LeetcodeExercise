package TwoPointers.P1570DotProductOfTwoSparseVectors;

import junit.framework.TestCase;

/**
 * @CLassName SparseVectorTest
 * @Description TODO
 * @Author cst
 * @Date 12/20/20  2:10 PM
 */
public class SparseVectorTest extends TestCase {
    public void test() {
        int[] nums1 = {1,0,0,2,3};
        int[] nums2 = {0,3,0,4,0};
        SparseVector sv1 = new SparseVector(nums1);
        SparseVector sv2 = new SparseVector(nums2);
        assertEquals(8, sv1.dotProduct(sv2));

    }
}
