package Graph.P269AlienDictionary;

import junit.framework.TestCase;

/**
 * @CLassName AlienDictionaryTest
 * @Description TODO
 * @Author cst
 * @Date 1/28/21  10:50 AM
 */
public class AlienDictionaryTest extends TestCase {
    public void testAlienOrder() {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        assertEquals("wertf", new AlienDictionary().alienOrder(words));

        words = new String[]{"abc", "ab"};
        assertEquals("", new AlienDictionary().alienOrder(words));

        words = new String[]{"ab", "abc"};
        assertEquals("abc", new AlienDictionary().alienOrder(words));
    }
}
