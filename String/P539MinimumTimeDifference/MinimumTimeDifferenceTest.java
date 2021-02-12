package String.P539MinimumTimeDifference;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * @CLassName MinimumTimeDifferenceTest
 * @Description TODO
 * @Author cst
 * @Date 2/8/21  1:39 PM
 */
public class MinimumTimeDifferenceTest extends TestCase {
    public void testFindMinDifference() {
        List<String> timePoints = Arrays.asList("00:00","23:59","00:00");
        assertEquals(0, new MinimumTimeDifference().findMinDifference(timePoints));

        timePoints = Arrays.asList("01:01","02:01","03:00","03:01");
        assertEquals(1, new MinimumTimeDifference().findMinDifference(timePoints));
    }
}
