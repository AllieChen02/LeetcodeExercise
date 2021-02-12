package String.P1698NumberOfDistinctSubstringsInAString;

import java.util.HashSet;
import java.util.Set;

/**
 * @CLassName NumberOfDistinctSubstringsInAString
 * @Description Given a string s, return the number of distinct substrings of s.
 * <p>
 * A substring of a string is obtained by deleting any number of characters (possibly zero) from the front of the string and any number (possibly zero) from the back of the string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabbaba"
 * Output: 21
 * Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
 * Example 2:
 * <p>
 * Input: s = "abcdefg"
 * Output: 28
 * @Author cst
 * @Date 2/6/21  5:13 PM
 */
public class NumberOfDistinctSubstringsInAString {
    public int countDistinct(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String str = s.substring(j, i + 1);
                set.add(str);
            }
        }
        return set.size();
    }

    // Using Trie
    /*
     * 对每一个节点做一个trie, 其下面有26个children位置
     * */
    public int countDistinctTrie(String s) {
        Trie trie = new Trie();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            TrieNode node = trie.root;
            for (int j = i; j < s.length(); j++) {
                if (node.children[s.charAt(j) - 'a'] == null) {
                    res++;
                    node.children[s.charAt(j) - 'a'] = new TrieNode();
                }
                node = node.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }
}

class TrieNode {
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }
}
