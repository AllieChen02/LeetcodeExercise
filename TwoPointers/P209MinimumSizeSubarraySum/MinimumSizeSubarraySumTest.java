package TwoPointers.P209MinimumSizeSubarraySum;

import junit.framework.TestCase;

public class MinimumSizeSubarraySumTest extends TestCase {
    public void testMinSubArrayLen() {
        int s = 7;
        int[] arr = new int[]{2,3,1,2,4,3};
        assertEquals(2, new MinimumSizeSubarraySum().minSubArrayLen(s, arr));

        s = 3;
        arr = new int[]{1,1};
        assertEquals(0, new MinimumSizeSubarraySum().minSubArrayLen(s, arr));
    }
}
