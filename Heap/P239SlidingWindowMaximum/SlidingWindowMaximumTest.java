package Heap.P239SlidingWindowMaximum;

import junit.framework.TestCase;

/**
 * @CLassName SlidingWindowMaximumTest
 * @Description TODO
 * @Author cst
 * @Date 1/21/21  12:19 AM
 */
public class SlidingWindowMaximumTest extends TestCase {
    public void testMaxSlidingWindow() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        assertEquals(3, res[0]);
        assertEquals(3, res[1]);
        assertEquals(5, res[2]);
        assertEquals(5, res[3]);
        assertEquals(6, res[4]);
        assertEquals(7, res[5]);

    }
}
