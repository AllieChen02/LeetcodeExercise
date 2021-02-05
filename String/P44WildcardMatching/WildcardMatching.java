package String.P44WildcardMatching;

/**
 * @CLassName WildcardMatching
 * @Description Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 * @Author cst
 * @Date 2/4/21  12:11 PM
 */
public class WildcardMatching {
    /*
    dp[i][j]
    Case 1: if c[i] == c[j]
                dp[i+1][j+1] = dp[i][j]
    Case 2: if c[i] != c[j]
                case 2-1: if c[j] == ?, dp[i+1][j+1] = dp[i][j]
                case 2-2: if c[j] == *, dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j]
                case 2-3: false
    * */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else if(p.charAt(j) == '?') {
                    dp[i+1][j+1] = dp[i][j];
                } else if(p.charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                } else {
                    return false;
                }
            }
        }
        return dp[m][n];
    }
}
