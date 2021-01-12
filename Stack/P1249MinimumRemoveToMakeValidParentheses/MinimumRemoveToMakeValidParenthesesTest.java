package Stack.P1249MinimumRemoveToMakeValidParentheses;

import junit.framework.TestCase;

/**
 * @CLassName MinimumRemoveToMakeValidParenthesesTest
 * @Description TODO
 * @Author cst
 * @Date 1/10/21  3:29 PM
 */
public class MinimumRemoveToMakeValidParenthesesTest extends TestCase {
    public void testMinRemoveToMakeValid() {
        String s = new String("lee(t(c)o)de)");
        assertEquals("lee(t(c)o)de", new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));

        s = new String("a)b(c)d");
        assertEquals("ab(c)d", new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s));
    }
}
