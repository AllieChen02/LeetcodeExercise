package Graph.P269AlienDictionary;

import java.util.*;

/**
 * @CLassName AlienDictionary
 * @Description There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
 * <p>
 * You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * <p>
 * Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are multiple valid solutions, return any of them.
 * <p>
 * Example 1:
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * <p>
 * Example 2:
 * Input: words = ["z","x"]
 * Output: "zx"
 * <p>
 * Example 3:
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 * @Author cst
 * @Date 1/28/21  10:06 AM
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                graph.put(c, new HashSet<>());
            }
        }
        int[] inDegree = new int[26];
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String next = words[i];
            // In a valid alphabet, prefixes are always first
            if (prev.length() > next.length() && prev.startsWith(next)) {
                return "";
            }
            int size = Math.min(prev.length(), next.length());
            for (int j = 0; j < size; j++) {
                char p = prev.charAt(j);
                char n = next.charAt(j);
                if (p != n) {
                    if (graph.get(p).add(n)) {
                        inDegree[n - 'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char curr = queue.poll();
                sb.append(curr);
                for (char child : graph.get(curr)) {
                    inDegree[child - 'a']--;
                    if (inDegree[child - 'a'] == 0) {
                        queue.offer(child);
                    }
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
