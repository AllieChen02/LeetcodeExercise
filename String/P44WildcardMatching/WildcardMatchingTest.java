package String.P44WildcardMatching;

import junit.framework.TestCase;

/**
 * @CLassName WildcardMatchingTest
 * @Description TODO
 * @Author cst
 * @Date 2/4/21  3:49 PM
 */
public class WildcardMatchingTest extends TestCase {
    public void testIsMatch() {
        String s = "adceb";
        String p = "*a*b";
        assertFalse(new WildcardMatching().isMatch(s, p));
    }
}
