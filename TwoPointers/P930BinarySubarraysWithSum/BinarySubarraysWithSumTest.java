package TwoPointers.P930BinarySubarraysWithSum;

import junit.framework.TestCase;

/**
 * @CLassName BinarySubarraysWithSumTest
 * @Description TODO
 * @Author cst
 * @Date 12/20/20  2:44 PM
 */
public class BinarySubarraysWithSumTest extends TestCase {
    public void testNumSubarraysWithSum() {
        int[] arr = new int[]{1,0,1,0,1};
        int S = 2;
        assertEquals(4, new BinarySubarraysWithSum().numSubarraysWithSum(arr, S));
    }
}
