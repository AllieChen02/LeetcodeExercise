package Stack.P224BasicCalculator;

import junit.framework.TestCase;

/**
 * @CLassName BasicCalculatorTest
 * @Description TODO
 * @Author cst
 * @Date 1/12/21  11:08 PM
 */
public class BasicCalculatorTest extends TestCase {
    public void testCalculate() {
        String s = "1 + 1";
        assertEquals(2, BasicCalculator.getONLY().calculate(s));

        s = "(1+(4+5+2)-3)+(6+8)";
        assertEquals(23, BasicCalculator.getONLY().calculate(s));
    }
}
