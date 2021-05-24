package Heap.P1673FindTheMostCompetitiveSubsequence;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @CLassName FindTheMostCompetitiveSubsequenceTest
 * @Description TODO
 * @Author cst
 * @Date 5/23/21  10:49 PM
 */
public class FindTheMostCompetitiveSubsequenceTest extends TestCase {
    public void testMostCompetitive() {
        int[] nums = new int[]{2,4,3,3,5,4,9,6};
        int k = 4;
        Assert.assertArrayEquals(new int[]{2,3,3,4}, FindTheMostCompetitiveSubsequence.mostCompetitive(nums, k));
    }
}
