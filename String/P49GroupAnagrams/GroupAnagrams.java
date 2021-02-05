package String.P49GroupAnagrams;

import java.util.*;

/**
 * @CLassName GroupAnagrams
 * @Description
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]
 *
 * @Author cst
 * @Date 2/3/21  1:49 PM
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = str;
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            System.out.println(new String(ch));
            if(!map.containsKey(new String(ch))) {
                map.put(new String(ch), new ArrayList<>());
            }
            map.get(new String(ch)).add(temp);
        }
        res.addAll(map.values());
        return res;
    }
}
