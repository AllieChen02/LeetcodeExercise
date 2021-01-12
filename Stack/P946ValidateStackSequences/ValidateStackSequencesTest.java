package Stack.P946ValidateStackSequences;

import junit.framework.TestCase;

/**
 * @CLassName ValidateStackSequencesTest
 * @Description TODO
 * @Author cst
 * @Date 1/11/21  10:23 PM
 */
public class ValidateStackSequencesTest extends TestCase {
    public void testValidateStackSequences() {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        assertTrue(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}
