package TwoPointers.P3LongestSubstringWithoutRepeatingCharacters;

import junit.framework.TestCase;

public class LongestSubstringWithoutRepeatingCharactersTest extends TestCase {

    public void testLengthOfLongestSubstring() {
        String s = "abcabcbb";
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

        s = "bbbbb";
        assertEquals(1, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

        s = "pwwkew";
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));

        s = "";
        assertEquals(0, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
