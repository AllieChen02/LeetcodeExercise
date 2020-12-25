package TwoPointers.P845LongestMountainInArray;

import junit.framework.TestCase;

public class LongestMountainInArrayTest extends TestCase {
    public void testLongestMountain() {
        int[] arr = new int[]{2,1,4,7,3,2,5};
        assertEquals(5, new LongestMountainInArray().longestMountain(arr));
        assertEquals(5, new LongestMountainInArray().longestMountain_1(arr));

        arr = new int[]{2,2,2};
        assertEquals(0, new LongestMountainInArray().longestMountain(arr));
        assertEquals(0, new LongestMountainInArray().longestMountain_1(arr));
    }
    
}
