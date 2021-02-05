package String.P1653MinimumDeletionsToMakeStringBalanced;

/**
 * @CLassName MinimumDeletionsToMakeStringBalanced
 * @Description
 * You are given a string s consisting only of characters 'a' and 'b'.
 *
 * You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
 *
 * Return the minimum number of deletions needed to make s balanced.
 *
 * Example 1:
 *
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 * Example 2:
 *
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 * @Author cst
 * @Date 2/4/21  4:04 PM
 */
public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int numOfA = s.chars().map(c -> c == 'a' ? 1 : 0).sum();
        int numOfB = 0;
        int res = s.length();
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == 'b') {
                res = Math.min(res, numOfA + numOfB);
                numOfB += 1;
            } else {
                numOfA -= 1;
            }
        }
        return Math.min(res, numOfA + numOfB);
    }
}
