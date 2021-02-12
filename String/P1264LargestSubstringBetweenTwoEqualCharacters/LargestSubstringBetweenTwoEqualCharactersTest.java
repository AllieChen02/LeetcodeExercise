package String.P1264LargestSubstringBetweenTwoEqualCharacters;

import junit.framework.TestCase;

/**
 * @CLassName LargestSubstringBetweenTwoEqualCharactersTest
 * @Description TODO
 * @Author cst
 * @Date 2/7/21  2:23 PM
 */
public class LargestSubstringBetweenTwoEqualCharactersTest extends TestCase {
    public void testMaxLengthBetweenEqual() {
        String s = "abca";
        assertEquals(2, new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters(s));
    }
}
