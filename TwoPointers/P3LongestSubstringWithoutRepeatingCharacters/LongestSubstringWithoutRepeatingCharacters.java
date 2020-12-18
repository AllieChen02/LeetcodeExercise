package TwoPointers.P3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0){
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int start = 0, end = 0;
        while(end < ch.length) {
            map.put(ch[end], map.getOrDefault(ch[end], 0) + 1);
            while (map.get(ch[end]) > 1) {
                map.put(ch[start], map.get(ch[start])-1);
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
