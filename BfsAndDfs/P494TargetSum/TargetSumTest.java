package BfsAndDfs.P494TargetSum;

import junit.framework.TestCase;

/**
 * @CLassName TargetSumTest
 * @Description TODO
 * @Author cst
 * @Date 1/21/21  1:43 PM
 */
public class TargetSumTest extends TestCase {
    public void testFindTargetSumWays() {
        int[] nums = new int[]{1,1,1,1,1};
        int S = 3;
        assertEquals(5, new TargetSum().findTargetSumWays(nums, S));
    }
}
