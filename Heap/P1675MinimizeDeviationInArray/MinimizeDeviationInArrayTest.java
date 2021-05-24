package Heap.P1675MinimizeDeviationInArray;

import Heap.P1439FindTheKthSmallestSumofAMatrixWithSort.FindTheKthSmallestSumofAMatrixWithSort;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @CLassName MinimizeDeviationInArrayTest
 * @Description TODO
 * @Author cst
 * @Date 5/23/21  3:13 PM
 */
public class MinimizeDeviationInArrayTest extends TestCase {
    public void testMinimumDeviation() {
        int[] nums = new int[]{1,2,3,4};
        Assert.assertEquals(1, MinimizeDeviationInArray.minimumDeviation(nums));

        nums = new int[]{4,1,5,20,3};
        Assert.assertEquals(3, MinimizeDeviationInArray.minimumDeviation(nums));
    }
}
