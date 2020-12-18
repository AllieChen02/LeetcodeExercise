package TwoPointers.P1004MaxConsecutiveOnesIII;

import junit.framework.TestCase;

public class MaxConsecutiveOnesIIITest extends TestCase {
    public void testLongestOnes() {
        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        assertEquals(6, new MaxConsecutiveOnesIII().longestOnes(arr, K));

        arr = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        K = 3;
        assertEquals(10, new MaxConsecutiveOnesIII().longestOnes(arr, K));
    }
}
