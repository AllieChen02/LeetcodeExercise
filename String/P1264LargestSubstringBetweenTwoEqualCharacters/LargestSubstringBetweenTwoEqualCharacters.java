package String.P1264LargestSubstringBetweenTwoEqualCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName LargestSubstringBetweenTwoEqualCharacters
 * @Description TODO
 * @Author cst
 * @Date 2/7/21  2:11 PM
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        char[] ch = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], new ArrayList<>());
            }
            map.get(ch[i]).add(i);
        }
        for (List<Integer> list : map.values()) {
            if (list.size() <= 1) {
                continue;
            }
            res = Math.max(res, list.get(list.size() - 1) - list.get(0) - 1);
        }
        return res;
    }
}
