package String.P1653MinimumDeletionsToMakeStringBalanced;

import junit.framework.TestCase;

/**
 * @CLassName MinimumDeletionsToMakeStringBalancedTest
 * @Description TODO
 * @Author cst
 * @Date 2/4/21  10:29 PM
 */
public class MinimumDeletionsToMakeStringBalancedTest extends TestCase {
    public void testMinimumDeletions() {
        String s = new String("aababbab");
        assertEquals(2, new MinimumDeletionsToMakeStringBalanced().minimumDeletions(s));
    }
}
