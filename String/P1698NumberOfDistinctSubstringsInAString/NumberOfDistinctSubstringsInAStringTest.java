package String.P1698NumberOfDistinctSubstringsInAString;

import junit.framework.TestCase;

/**
 * @CLassName NumberOfDistinctSubstringsInAStringTest
 * @Description TODO
 * @Author cst
 * @Date 2/7/21  11:07 AM
 */
public class NumberOfDistinctSubstringsInAStringTest extends TestCase {
    public void testCountDistinct() {
        String s = "aabbaba";
        assertEquals(21, new NumberOfDistinctSubstringsInAString().countDistinct(s));
        assertEquals(21, new NumberOfDistinctSubstringsInAString().countDistinctTrie(s));
        s = "abcdefg";
        assertEquals(28, new NumberOfDistinctSubstringsInAString().countDistinct(s));
        assertEquals(28, new NumberOfDistinctSubstringsInAString().countDistinctTrie(s));
    }
}
