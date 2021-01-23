package Stack.P316RemoveDuplicateLetters;

import junit.framework.TestCase;

/**
 * @CLassName RemoveDuplicateLettersTest
 * @Description TODO
 * @Author cst
 * @Date 1/18/21  11:24 AM
 */
public class RemoveDuplicateLettersTest extends TestCase {
    public void testRemoveDuplicateLetters() {
        String s = "bcabc";
        assertEquals("abc", new RemoveDuplicateLetters().removeDuplicateLetters(s));

        s = "cbacdcbc";
        assertEquals("acdb", new RemoveDuplicateLetters().removeDuplicateLetters(s));
    }
}
